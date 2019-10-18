package br.com.hackathon.configuration.security;

import br.com.hackathon.domain.User;
import br.com.hackathon.repository.UserRepository;
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
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = this.getUser(() -> this.userRepository.findByEmail(username));
		this.userRepository.save(user);
		return UserPrincipal.create(user);
	}

	UserDetails loadUserById(Long id) {
		User user = this.getUser(() -> this.userRepository.findById(id));
		this.userRepository.save(user);
		return UserPrincipal.create(user);
	}

	private User getUser(Supplier<Optional<User>> supplier) {
		return supplier.get().orElseThrow(() ->
				new UsernameNotFoundException(USER_NOT_FOUND)
		);
	}
}
