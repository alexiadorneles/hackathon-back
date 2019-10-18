package br.com.hackathon.mapper.user;

import br.com.hackathon.dto.user.CreateUserDto;
import br.com.hackathon.domain.User;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public class UserMapper {
	private UserMapper() {
	}

	public static User fromCadastroDtoToModel(CreateUserDto cadastroDto) {
		return User.builder()
				.email(cadastroDto.getEmail())
				.lastName(cadastroDto.getLastName())
				.firstName(cadastroDto.getFirstName())
				.password(cadastroDto.getPassword())
				.build();
	}

}
