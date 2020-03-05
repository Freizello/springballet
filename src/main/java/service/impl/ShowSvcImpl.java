package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.RoleDao;
import dao.ShowDao;
import dto.RoleDto;
import dto.ShowDto;
import entity.Role;
import entity.Show;
import entity.ShowPK;
import service.ShowSvc;

@Service("showSvc")
@Transactional
public class ShowSvcImpl implements ShowSvc {

	@Autowired
	private ShowDao showDao;
	
	@Autowired
	private RoleDao roleDao;
		
	@Override
	public List<ShowDto> findAll() {
		List<ShowDto> showDtos = new ArrayList<>();
		List<Show> shows = showDao.findAll();
		for(Show show : shows) {
			ShowDto showDto = new ShowDto();
			showDto.setSid(show.getSid());
			showDto.setTitle(show.getTitle());
			showDto.setChoreo(show.getChoreo());
			showDto.setComposer(show.getComposer());
			showDto.setYear(show.getYear());
			
//			List<RoleDto> roleDtos = new ArrayList<>();
//			List<Object[]> roles = roleDao.findAllBySid(show.getSid());
//			for(Object[] o: roles) {
//				RoleDto roleDto = new RoleDto();
//				Role role = (Role) o[0];
//				String name = (String) o[1];
//				roleDto.setDid(role.getDid());
//				roleDto.setName(name);
//				roleDto.setSid(role.getSid());
//				roleDto.setRole(role.getRole());
//				roleDto.setCname(role.getCname());
//				roleDtos.add(roleDto);
//			}
//			showDto.setRoleDtos(roleDtos);			
			showDtos.add(showDto);
		}
		return showDtos;
	}

	@Override
	public void save(ShowDto showDto) {
		Show show = new Show();
		show.setSid(showDto.getSid());
		show.setTitle(showDto.getTitle());
		show.setChoreo(showDto.getChoreo());
		show.setComposer(showDto.getComposer());
		show.setYear(showDto.getYear());
		showDao.save(show);
		roleDao.deleteBySid(showDto.getSid());
		List<RoleDto> roleDtos = showDto.getRoleDtos();
		for(RoleDto roleDto : roleDtos) {
			Role role = new Role();
			role.setDid(roleDto.getDid());
			role.setSid(showDto.getSid());
			role.setRole(roleDto.getRole());
			role.setCname(roleDto.getCname());
			roleDao.save(role);			
		}
	}

	@Override
	public void delete(ShowDto showDto) {
		ShowPK showPK = new ShowPK();
		showPK.setSid(showDto.getSid());
		showDao.delete(showPK);		
		roleDao.deleteBySid(showDto.getSid());
	}

	@Override
	public ShowDto getById(ShowDto dto) {
		ShowPK showPK = new ShowPK();
		showPK.setSid(dto.getSid());
		Show show = showDao.findOne(showPK);
		
		ShowDto showDto = new ShowDto();
		showDto.setSid(show.getSid());
		showDto.setTitle(show.getTitle());
		showDto.setChoreo(show.getChoreo());
		showDto.setComposer(show.getComposer());
		showDto.setYear(show.getYear());
		List<RoleDto> roleDtos = new ArrayList<>();
		List<Object[]> roles = roleDao.findAllBySid(show.getSid());
		for(Object[] o: roles) {
			RoleDto roleDto = new RoleDto();
			Role role = (Role) o[0];
			String name = (String) o[1];
			roleDto.setDid(role.getDid());
			roleDto.setName(name);
			roleDto.setSid(role.getSid());
			roleDto.setRole(role.getRole());
			roleDto.setCname(role.getCname());
			roleDtos.add(roleDto);
		}
		showDto.setRoleDtos(roleDtos);
		return showDto;
	}

}
