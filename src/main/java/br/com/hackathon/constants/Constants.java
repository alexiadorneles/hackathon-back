package br.com.hackathon.constants;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public abstract class Constants {
	private Constants() {
	}

	// AUTH
	public static final String HEADER_PREFIX = "Bearer";
	public static final Integer JWT_EXPIRATION = 86400000;

	// VALIDATION
	public static final String REG_EXP_EMAIL_VALIDATION = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

	// MESSAGES
	public static final String USER_NOT_FOUND = "Usuário não encontrado.";
	public static final String INCORRECT_EMAIL_MESSAGE = "Email em formato incorreto";
	public static final String FORBIDDEN_ACTION = "Usuário não autorizado para realizar ação!";
	public static final String INVALID_DATA = "Dados inválidos: not null estão nulos!";

}
