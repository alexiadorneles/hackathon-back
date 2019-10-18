package br.com.hackathon.configuration.security;

import br.com.hackathon.model.User;
import br.com.hackathon.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

import static br.com.hackathon.constants.Constants.USER_NOT_FOUND;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User usuario = this.getUser(() -> this.usuarioRepository.findByEmail(username));
		this.usuarioRepository.save(usuario);
		return UserPrincipal.create(usuario);
	}

	UserDetails loadUserById(Long id) {
		User usuario = this.getUser(() -> this.usuarioRepository.findById(id));
		this.usuarioRepository.save(usuario);
		return UserPrincipal.create(usuario);
	}

	private User getUser(Supplier<Optional<User>> supplier) {
		return supplier.get().orElseThrow(() ->
				new UsernameNotFoundException(USER_NOT_FOUND)
		);
	}
}
