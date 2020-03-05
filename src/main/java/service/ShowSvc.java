package service;

import java.util.List;

import dto.ShowDto;

public interface ShowSvc {
	
	public List<ShowDto> findAll();
	public void save(ShowDto showDto);
	public void delete(ShowDto showDto);
	public ShowDto getById(ShowDto showDto);
}
