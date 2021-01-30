package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Utilisateur;

@Repository
public interface IUserDao  extends JpaRepository<Utilisateur, Integer>{
	
	public List<Utilisateur> findByUsernameAndPassword(String username, String password );
	
	public Utilisateur findByUsername(String username);
}
