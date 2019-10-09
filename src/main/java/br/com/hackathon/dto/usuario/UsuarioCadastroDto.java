package br.com.hackathon.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioCadastroDto {

	private String googleId;

	private String photo;

	private String email;

	private String firstName;

	private String lastName;

	public String generatePassword() {
		return this.email.concat("PASS").concat(this.googleId);
	}
}
