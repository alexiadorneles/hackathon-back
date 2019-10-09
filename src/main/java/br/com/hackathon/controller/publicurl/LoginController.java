package br.com.hackathon.controller.publicurl;

import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hackathon.configuration.security.AuthenticationService;
import br.com.hackathon.dto.login.LoginResponseDto;
import br.com.hackathon.dto.usuario.UsuarioCadastroDto;

@RestController
@RequestMapping("/public/login")
public class LoginController {

	@Inject
	private AuthenticationService authenticationService;

	@GetMapping
	public boolean health() {
		return true;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public LoginResponseDto login(@RequestBody UsuarioCadastroDto cadastroDto) {
		return this.authenticationService.authenticate(cadastroDto);
	}

}
