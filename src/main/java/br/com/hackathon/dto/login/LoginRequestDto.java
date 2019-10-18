package br.com.hackathon.dto.login;

import lombok.Data;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Data
public class LoginRequestDto {
	private final String email;
	private final String password;
}
