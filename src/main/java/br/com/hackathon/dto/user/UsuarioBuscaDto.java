package br.com.hackathon.dto.user;

import java.time.LocalDate;

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
public class UsuarioBuscaDto {
	private Long idUsuario;

	private String dsFoto;

	private String nmUsuario;

	private String dsSobrenome;

	private String dsEmail;

	private LocalDate dtNascimento;

	private LocalDate dtUltimoAcesso;
}
