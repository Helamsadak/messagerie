package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sujet;
	private String contenu;
	
	@ManyToOne
	@JoinColumn(name = "send_id")
	private Utilisateur usersend;
	@ManyToOne
	@JoinColumn(name = "receive_id")
	private Utilisateur userreceive;
	
	
	public Message(Integer id, String sujet, String contenu, Utilisateur usersend, Utilisateur userreceive) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.contenu = contenu;
		this.usersend = usersend;
		this.userreceive = userreceive;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Utilisateur getUsersend() {
		return usersend;
	}
	public void setUsersend(Utilisateur usersend) {
		this.usersend = usersend;
	}
	public Utilisateur getUserreceive() {
		return userreceive;
	}
	public void setUserreceive(Utilisateur userreceive) {
		this.userreceive = userreceive;
	}
	
	
	
	
	
	
}
