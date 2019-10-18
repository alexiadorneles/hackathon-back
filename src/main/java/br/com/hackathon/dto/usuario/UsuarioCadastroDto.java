package br.com.hackathon.dto.usuario;

import lombok.*;

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

	private String photo;

	private String email;

	private String firstName;

	private String lastName;

	private String password;

}
