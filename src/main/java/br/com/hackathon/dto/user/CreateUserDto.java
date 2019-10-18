package br.com.hackathon.dto.user;

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
public class CreateUserDto {

	private String photo;

	private String email;

	private String firstName;

	private String lastName;

	private String password;

}
