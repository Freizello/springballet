package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="dancer")
@IdClass(DancerPK.class)
public class Dancer {
	
	private int did;
	private String name;
	private int birthyear;
	private String country;
	
	@Id
	@Column(name="did")
	public int getDid() {
		return did;
	}
	
	public void setDid(int did) {
		this.did = did;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="birthyear")
	public int getBirthyear() {	
		return birthyear;
	}
	
	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}
	
	@Column(name="country")
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

}
