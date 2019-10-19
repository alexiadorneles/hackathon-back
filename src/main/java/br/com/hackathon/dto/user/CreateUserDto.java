package br.com.hackathon.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author eduardo.thums
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

	@Email
	@Size(max = 2048)
	private String email;

	@NotBlank
	@Size(max = 512)
	private String password;

	@NotBlank
	@Size(max = 512)
	private String firstName;

	@NotBlank
	@Size(max = 512)
	private String lastName;

	@NotBlank
	@Size(max = 2048)
	private String imageUrl;

	@Size(max = 11)
	private String cpf;

	@Size(max = 14)
	private String cnpj;

	private Long latitude;

	private Long longitude;
}
