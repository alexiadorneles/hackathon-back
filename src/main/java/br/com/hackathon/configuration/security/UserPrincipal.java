package br.com.hackathon.configuration.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.hackathon.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	private String nmUsuario;

	private String dsSobrenome;

	private String dsEmail;

	private String dsLogin;

	@JsonIgnore
	private String dsSenha;

	private Collection<? extends GrantedAuthority> authorities;

	static UserPrincipal create(Usuario usuario) {
		List<GrantedAuthority> authorities = Collections.emptyList();

		return UserPrincipal.builder()
				.id(usuario.getIdUsuario())
				.nmUsuario(usuario.getNmUsuario())
				.dsSobrenome(usuario.getDsSobrenome())
				.dsEmail(usuario.getDsEmail())
				.dsLogin(usuario.getDsLogin())
				.dsSenha(usuario.getDsSenha())
				.authorities(authorities)
				.build();
	}

	@Override
	public String getUsername() {
		return this.dsLogin;
	}

	@Override
	public String getPassword() {
		return this.dsSenha;
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