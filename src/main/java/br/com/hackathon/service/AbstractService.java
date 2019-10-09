package br.com.hackathon.service;

import java.security.Principal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.hackathon.model.Usuario;
import br.com.hackathon.repository.UsuarioRepository;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Service
public abstract class AbstractService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario getPrincipal() {
		Principal principal = SecurityContextHolder.getContext().getAuthentication();
		Optional<Usuario> userPrincipal = this.usuarioRepository.findByDsLogin(principal.getName());
		return userPrincipal.orElse(null);
	}

}
