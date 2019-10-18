package br.com.hackathon.service;

import br.com.hackathon.model.User;
import br.com.hackathon.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Service
public abstract class AbstractService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public User getPrincipal() {
		Principal principal = SecurityContextHolder.getContext().getAuthentication();
		Optional<User> userPrincipal = this.usuarioRepository.findByEmail(principal.getName());
		return userPrincipal.orElse(null);
	}

}
