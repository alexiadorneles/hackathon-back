package br.com.hackathon.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author eduardo.thums
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RankUserDto {

	private String fullName;

	private String imageUrl;

	@JsonIgnore
	private String cpf;

	@JsonIgnore
	private String cnpj;
}
