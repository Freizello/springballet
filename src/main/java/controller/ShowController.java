package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import dto.CompanyDto;
import dto.DancerDto;
import dto.RoleDto;
import dto.ShowDto;
import entity.ShowPK;
import service.CompanySvc;
import service.DancerSvc;
import service.ShowSvc;

@Controller
public class ShowController {

	@Autowired
	ShowSvc showSvc;

	@Autowired
	DancerSvc dancerSvc;

	@Autowired
	CompanySvc companySvc;

	List<RoleDto> roleList = new ArrayList<RoleDto>();
	List<ShowDto> showList = new ArrayList<ShowDto>();;

	@RequestMapping("/ballet/show")
	public String show(Model model, HttpServletRequest request) {
		roleList.clear();
		
		List<ShowDto> dtos = showSvc.findAll();
		model.addAttribute("dto", dtos);
		return "show";
	}

//	, HttpServletRequest request
	@RequestMapping("/ballet/add")
	public String Add(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ShowDto dto = new ShowDto();
		session.removeAttribute("showId");
		
		if (session.getAttribute("roleCollection") == null) {
			roleList.clear();			
		}
		
		dto.setRoleDtos((List<RoleDto>) session.getAttribute("roleCollection"));
		
		model.addAttribute("showDto", dto);
		return "show_add";
	}

	@RequestMapping("/ballet/save")
	public String Save(@Valid @ModelAttribute("showDto") ShowDto showDto, BindingResult result, ModelMap model) {
		
		showSvc.save(showDto);
		return "redirect:/ballet/show";
	}

	@RequestMapping("/ballet/addRole")
	public String addRole(Model model, @ModelAttribute("showDto") ShowDto showDto) {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("sesilogin")==null&&
//				session.getAttribute("kodeKaryawan")==null&&
//				session.getAttribute("OK")==null){
//	
//			return "redirect:/login";
//		}
		List<DancerDto> dancerDtos = dancerSvc.findAll(); // Dropdown dancer
		List<CompanyDto> companyDtos = companySvc.findAll(); // Dropdown company
		
		RoleDto roleDto = new RoleDto();
		model.addAttribute("roleDto", roleDto);
		model.addAttribute("listDancer", dancerDtos);
		model.addAttribute("listCompany", companyDtos);
		
		if (showList != null) {
			showList.add(showDto);
		} else {
			showList.clear();
			showList.add(showDto);
		}
		return "show_add_role";
	}

	@RequestMapping("/ballet/saveRole")
	public String saveRole(@Valid @ModelAttribute("roleDto") RoleDto roleDto, BindingResult result, ModelMap model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
//		if(session.getAttribute("sesilogin")==null&&
//				session.getAttribute("kodeKaryawan")==null&&
//				session.getAttribute("OK")==null){
//	
//			return "redirect:/login";
//		}
		
		if (session.getAttribute("roleCollection") == null) {
			roleList.clear();
		}
		
		DancerDto dancerdto = dancerSvc.findById(roleDto.getDid());
		roleDto.setName(dancerdto.getName());
		roleList.add(roleDto);
		session.setAttribute("roleCollection", roleList);
		
		if (result.hasErrors()) {
			return "show_add_role";
		} else {
			
			if (session.getAttribute("showId") == null) {
				return "redirect:/ballet/add";
			} else {
				String id = String.valueOf(session.getAttribute("showId"));
				return "redirect:/ballet/"+id;
			}
			
		}
	}
	
	@RequestMapping("/ballet/{showId}")
	public String detail(@PathVariable("showId") int showId, Model model, HttpServletRequest request) {
		ShowDto showDto = new ShowDto();
		HttpSession session = request.getSession();
		
		showDto.setSid(showId);
		showDto = showSvc.getById(showDto);
		
		session.setAttribute("showId", showId);
		
		if (session.getAttribute("roleCollection") == null) {
			roleList = showDto.getRoleDtos();	
		} else {
			roleList = (List<RoleDto>) session.getAttribute("roleCollection");
		}
		session.setAttribute("roleCollection", roleList);
		
		showDto.setRoleDtos(roleList);
		model.addAttribute("showDto", showDto);
		return "show_edit";
	}
	
	@RequestMapping("/ballet/delete/{id}")
	public String delete(@PathVariable("id") int showId) {
		ShowDto showDto = new ShowDto();
		showDto.setSid(showId);
		showDto = showSvc.getById(showDto);
		showSvc.delete(showDto);
		return "redirect:/ballet/show";
	}
}
