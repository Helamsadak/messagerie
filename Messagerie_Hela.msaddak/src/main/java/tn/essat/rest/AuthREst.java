package tn.essat.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.config.GestionToken;
import tn.essat.config.JwtRequest;
import tn.essat.config.JwtResponse;
import tn.essat.model.Utilisateur;
import tn.essat.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/auth")
public class AuthREst {

	@Autowired
	GestionToken token_gen;
	
	@Autowired
	UserService service;
	@Autowired
	AuthenticationManager authenticationManager ;
	
	
	@PostMapping("/login")
	public JwtResponse test(@RequestBody JwtRequest request) {
		
		Authentication authen= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authen);
		
		Utilisateur u= (Utilisateur) service.loadUserByUsername(request.getUsername());
		String token=token_gen.generateToken(u);
		
		return new JwtResponse(token);
		
	}
	
	
}
