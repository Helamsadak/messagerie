package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.essat.model.Message;

@Repository
public interface IMessageDao extends JpaRepository<Message, Integer> {
	
	@Query("select m from Message m where m.usersend.id=?1")
	public List<Message> getAllMessagesEnvoyes(int id);
	
	@Query("select m from Message m where m.userreceive.id=?1")
	public List<Message> getAllMessagesRecus(int id);
	

}
