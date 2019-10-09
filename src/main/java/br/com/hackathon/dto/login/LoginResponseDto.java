package br.com.hackathon.dto.login;

import lombok.Builder;
import lombok.Data;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Data
@Builder
public class LoginResponseDto {
	private final String accessToken;
	private final Long idUsuario;
}
