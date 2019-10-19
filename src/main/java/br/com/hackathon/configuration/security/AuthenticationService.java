package br.com.hackathon.configuration.security;

import br.com.hackathon.domain.User;
import br.com.hackathon.dto.login.LoginResponseDto;
import br.com.hackathon.dto.user.CreateUserDto;
import br.com.hackathon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static br.com.hackathon.constants.Constants.HEADER_PREFIX;

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

	@Autowired
	private UserService userService;

	public LoginResponseDto authenticate(CreateUserDto createUserDto) {
		User user = userService.findByEmail(createUserDto.getEmail());
		if (Objects.isNull(user)) user = userService.save(createUserDto);

		Authentication authentication = this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						user.getEmail(),
						createUserDto.getPassword()
				)
		);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		Long idUsuario = userPrincipal.getId();

		return LoginResponseDto.builder()
				.accessToken(HEADER_PREFIX + this.tokenProvider.generateToken(authentication))
				.userId(idUsuario)
				.build();
	}
}
