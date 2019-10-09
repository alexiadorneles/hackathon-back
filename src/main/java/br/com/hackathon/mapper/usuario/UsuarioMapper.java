package br.com.hackathon.mapper.usuario;

import br.com.hackathon.dto.usuario.UsuarioCadastroDto;
import br.com.hackathon.model.Usuario;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public class UsuarioMapper {
	private UsuarioMapper() {
	}

	public static Usuario fromCadastroDtoToModel(UsuarioCadastroDto cadastroDto) {
		return Usuario.builder()
				.dsEmail(cadastroDto.getEmail())
				.dsLogin(cadastroDto.getEmail())
				.dsSobrenome(cadastroDto.getLastName())
				.nmUsuario(cadastroDto.getFirstName())
				.dsFoto(cadastroDto.getPhoto())
				.idGoogle(cadastroDto.getGoogleId())
				.dsSenha(cadastroDto.generatePassword())
				.build();
	}

}
