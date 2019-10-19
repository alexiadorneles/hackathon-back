package br.com.hackathon.configuration.security;

import br.com.hackathon.dto.login.LoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Service
public class AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	public String authenticate(LoginRequestDto request) {
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(),
						request.getPassword()
				)
		);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return tokenProvider.generateToken(authentication);
	}
}
