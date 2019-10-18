package br.com.hackathon.service;

import br.com.hackathon.domain.User;
import br.com.hackathon.repository.UserRepository;
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
	private UserRepository userRepository;

	public User getPrincipal() {
		Principal principal = SecurityContextHolder.getContext().getAuthentication();
		Optional<User> userPrincipal = this.userRepository.findByEmail(principal.getName());
		return userPrincipal.orElse(null);
	}

}
