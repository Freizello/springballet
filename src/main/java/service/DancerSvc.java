package service;

import java.util.List;

import dto.DancerDto;

public interface DancerSvc {

	public List<DancerDto> findAll();
	public DancerDto findById(int id);
}
