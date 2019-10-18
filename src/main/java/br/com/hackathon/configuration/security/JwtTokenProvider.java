package br.com.hackathon.configuration.security;

import static br.com.hackathon.configuration.security.Credentials.JWT_KEY;
import static br.com.hackathon.constants.Constants.JWT_EXPIRATION;
import static java.lang.Long.parseLong;
import static java.util.Optional.empty;

import java.util.Date;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Component
class JwtTokenProvider {
	String generateToken(Authentication authentication) {

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

		Date now = new Date();
		Date expiryDate = new Date(new Date().getTime() + JWT_EXPIRATION);

		return Jwts.builder()
				.setSubject(Long.toString(userPrincipal.getId()))
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, JWT_KEY)
				.claim("userId", userPrincipal.getId())
				.compact();
	}

	Optional<Long> getUserId(String jwt) {
		try {
			Claims claims = this.parse(jwt).getBody();
			return Optional.of(parseLong(claims.getSubject()));
		} catch (Exception ex) {
			return empty();
		}
	}

	private Jws<Claims> parse(String jwt) {
		return Jwts.parser().setSigningKey(JWT_KEY).parseClaimsJws(jwt);
	}
}
