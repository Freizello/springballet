package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Company;
import entity.CompanyPK;

public interface CompanyDao extends JpaRepository<Company, CompanyPK> {

}
