package dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ShowDto {

	@NotNull(message="Please input show id")
	@Valid
	private int sid;
	
	@NotEmpty(message="Please input title name")
	private String title;
	
	@NotEmpty(message="Please input choreo")
	private String choreo;
	
	@NotEmpty(message="Please input role name")
	private String composer;
	
	@NotNull(message="Please input year")
	@Valid
	@Min(value = 1850, message="Minimum year is 1850")
	private int year;
	
	@NotNull(message="Please input role")
	private List<RoleDto> roleDtos;
	
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getChoreo() {
		return choreo;
	}
	
	public void setChoreo(String choreo) {
		this.choreo = choreo;
	}
	
	public String getComposer() {
		return composer;
	}
	
	public void setComposer(String composer) {
		this.composer = composer;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public List<RoleDto> getRoleDtos() {
		return roleDtos;
	}
	
	public void setRoleDtos(List<RoleDto> roleDtos) {
		this.roleDtos = roleDtos;
	}
		
}
