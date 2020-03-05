package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="show")
@IdClass(ShowPK.class)
public class Show {

	private int sid;
	private String title;
	private String choreo;
	private String composer;
	private int year;
	
	@Id
	@Column(name="sid")
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="choreo")
	public String getChoreo() {
		return choreo;
	}
	
	public void setChoreo(String choreo) {
		this.choreo = choreo;
	}
	
	@Column(name="composer")
	public String getComposer() {
		return composer;
	}
	
	public void setComposer(String composer) {
		this.composer = composer;
	}
	
	@Column(name="year")
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
}
