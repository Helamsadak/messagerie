package tn.essat.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.essat.model.Utilisateur;


@Component
public class GestionToken {
	@Value("${auth.expiration}")
	private Long TOKEN_VALIDITY = 604800L;

	@Value("${auth.secret}")
	private String TOKEN_SECRET;

	public String generateToken(Utilisateur user) {

		return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
				.setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact();
	}

	public String getUserNameFromToken(String token) {
		Claims claims = getClaims(token);
		return claims.getSubject();
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
	}

	public boolean isTokenValid(String token, Utilisateur user) {
		String username = getUserNameFromToken(token);
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		Date expiration = getClaims(token).getExpiration();
		return expiration.before(new Date());
	}

	private Claims getClaims(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			claims = null;
		}

		return claims;
	}

}
