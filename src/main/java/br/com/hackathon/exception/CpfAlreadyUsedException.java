package br.com.hackathon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author eduardo.thums
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CpfAlreadyUsedException extends RuntimeException {
	public CpfAlreadyUsedException() {
		super("CPF already used");
	}
}
