package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Show;
import entity.ShowPK;

public interface ShowDao extends JpaRepository<Show, ShowPK> {

}
