package br.com.hackathon.configuration.security;

import br.com.hackathon.domain.entity.OrganizationEntity;
import br.com.hackathon.domain.entity.UserEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

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

	private String username;

	private String password;

	private String email;

	private Collection<? extends GrantedAuthority> authorities;

	static UserPrincipal createFromUser(UserEntity userEntity) {
		return UserPrincipal.builder()
				.id(userEntity.getId())
				.username(userEntity.getUsername())
				.email(userEntity.getEmail())
				.password(userEntity.getPassword())
				.authorities(Collections.emptyList())
				.build();
	}

	static UserPrincipal createFromOrganization(OrganizationEntity organizationEntity) {
		return UserPrincipal.builder()
				.id(organizationEntity.getId())
				.username(organizationEntity.getUsername())
				.email(organizationEntity.getEmail())
				.password(organizationEntity.getPassword())
				.authorities(Collections.emptyList())
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