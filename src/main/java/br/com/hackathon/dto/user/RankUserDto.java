package br.com.hackathon.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author eduardo.thums
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RankUserDto {

	private String fullName;

	private String imageUrl;

	@JsonIgnore
	private String cpf;

	@JsonIgnore
	private String cnpj;
}
