package br.com.hackathon.controller.publicurl;

import br.com.hackathon.configuration.security.AuthenticationService;
import br.com.hackathon.dto.login.LoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/login")
public class LoginController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping
	public ResponseEntity<String> login(@RequestBody LoginRequestDto request) {
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}
}
