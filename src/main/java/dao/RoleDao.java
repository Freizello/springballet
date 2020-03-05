package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import entity.Role;
import entity.RolePK;

public interface RoleDao extends JpaRepository<Role, RolePK> {
	
	@Query("select r, d.name from Role r, Dancer d where r.did = d.did and r.sid = ?")
	public List<Object[]> findAllBySid(int sid);
	
	@Modifying
	@Query("delete from Role r where r.sid = ?")
	public void deleteBySid(int sid);
	
}
