package tn.essat.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.IMessageDao;
import tn.essat.dao.IUserDao;
import tn.essat.model.Message;
import tn.essat.model.Utilisateur;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/rest")
public class AppRest {
	
	@Autowired
	IUserDao daou;
	@Autowired
	IMessageDao daom;
	
	
	@GetMapping("/messagesrecus/{id}")
	public List<Message> get1(@PathVariable("id") int id){
		return daom.getAllMessagesRecus(id);
	}	
	
	@GetMapping("/messagesenvoyes/{id}")
	public List<Message> get2(@PathVariable("id") int id){
		return daom.getAllMessagesEnvoyes(id);		
	}
	
	@PostMapping("/addMessage")
	public void addM(@RequestBody Message m) {
		//m.setUsersend();
		daom.save(m);
	}
	
	@DeleteMapping("/deleteMessage/{id}")
	public void get5(@PathVariable("id") int id){
		daom.deleteById(id);	
	}
	
	@GetMapping("/verif/{username}/{password}")
	public List<Utilisateur> get55(@PathVariable("username") String username, @PathVariable("password") String password){
		return daou.findByUsernameAndPassword(username, password);
	}
	
	
	@GetMapping("/users")
	public List<Utilisateur> get555(){
		return daou.findAll();
	}
	
	@GetMapping("/user/{username}")
	public Utilisateur get77(@PathVariable("username") String username) {
		return daou.findByUsername(username);
	}
	
	
	
	
	

}
