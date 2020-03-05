package entity;

import java.io.Serializable;

public class ShowPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int sid;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sid;
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
		ShowPK other = (ShowPK) obj;
		if (sid != other.sid)
			return false;
		return true;
	}
	
	
}
