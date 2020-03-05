package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CompanyDao;
import dto.CompanyDto;
import entity.Company;
import service.CompanySvc;

@Service("companySvc")
@Transactional
public class CompanySvcImpl implements CompanySvc {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public List<CompanyDto> findAll() {
		List<CompanyDto> companyDtos = new ArrayList<>();
		List<Company> companys = companyDao.findAll();
		for(Company company : companys) {
			CompanyDto companyDto = new CompanyDto();
			companyDto.setCname(company.getCname());
			companyDto.setCity(company.getCity());
			companyDto.setCountry(company.getCountry());
			companyDtos.add(companyDto);
		}
		return companyDtos;
	}

}
