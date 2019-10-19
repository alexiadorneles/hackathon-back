package br.com.hackathon.configuration.security;

import br.com.hackathon.domain.entity.OrganizationEntity;
import br.com.hackathon.domain.entity.UserEntity;
import br.com.hackathon.repository.OrganizationRepository;
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

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		final Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(username);

		if (!optionalUserEntity.isPresent()) {
			final OrganizationEntity organizationEntity = getOrganization(() -> organizationRepository.findByUsername(username));

			return UserPrincipal.createFromOrganization(organizationEntity);
		}

		return UserPrincipal.createFromUser(optionalUserEntity.get());
	}

	UserDetails loadUserById(Long id) {
		final UserEntity userEntity = this.getUser(() -> this.userRepository.findById(id));

		return UserPrincipal.createFromUser(userEntity);
	}

	UserDetails loadOrganizationById(Long id) {
		final OrganizationEntity organizationEntity = this.getOrganization(() -> organizationRepository.findById(id));

		return UserPrincipal.createFromOrganization(organizationEntity);
	}

	private UserEntity getUser(Supplier<Optional<UserEntity>> supplier) {
		return supplier.get().orElseThrow(() ->
				new UsernameNotFoundException(USER_NOT_FOUND)
		);
	}

	private OrganizationEntity getOrganization(Supplier<Optional<OrganizationEntity>> supplier) {
		return supplier.get().orElseThrow(() ->
				new UsernameNotFoundException(USER_NOT_FOUND)
		);
	}
}
