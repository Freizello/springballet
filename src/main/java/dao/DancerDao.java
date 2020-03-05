package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Dancer;
import entity.DancerPK;

public interface DancerDao extends JpaRepository<Dancer, DancerPK> {

}
