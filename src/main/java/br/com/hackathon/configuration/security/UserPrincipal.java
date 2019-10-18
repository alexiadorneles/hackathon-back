package br.com.hackathon.configuration.security;

import br.com.hackathon.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Data
@EqualsAndHashCode(of = "id")
public class UserPrincipal implements UserDetails {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	static UserPrincipal create(User user) {
		List<GrantedAuthority> authorities = Collections.emptyList();

		return UserPrincipal.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getEmail())
				.password(user.getPassword())
				.authorities(authorities)
				.build();
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}