package br.com.hackathon.mapper.usuario;

import br.com.hackathon.dto.usuario.UsuarioCadastroDto;
import br.com.hackathon.domain.User;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public class UsuarioMapper {
	private UsuarioMapper() {
	}

	public static User fromCadastroDtoToModel(UsuarioCadastroDto cadastroDto) {
		return User.builder()
				.email(cadastroDto.getEmail())
				.lastName(cadastroDto.getLastName())
				.firstName(cadastroDto.getFirstName())
				.password(cadastroDto.getPassword())
				.build();
	}

}
