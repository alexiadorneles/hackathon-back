package br.com.hackathon.configuration.security;

import static br.com.hackathon.constants.Constants.USER_NOT_FOUND;

import java.util.Optional;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.hackathon.model.Usuario;
import br.com.hackathon.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Usuario usuario = this.getUser(() -> this.usuarioRepository.findByDsLogin(username));
		this.usuarioRepository.save(usuario);
		return UserPrincipal.create(usuario);
	}

	UserDetails loadUserById(Long id) {
		Usuario usuario = this.getUser(() -> this.usuarioRepository.findByIdUsuario(id));
		this.usuarioRepository.save(usuario);
		return UserPrincipal.create(usuario);
	}

	private Usuario getUser(Supplier<Optional<Usuario>> supplier) {
		return supplier.get().orElseThrow(() ->
				new UsernameNotFoundException(USER_NOT_FOUND)
		);
	}
}
