package entity;

import java.io.Serializable;

public class DancerPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int did;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + did;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DancerPK other = (DancerPK) obj;
		if (did != other.did)
			return false;
		return true;
	}
	
	
}
