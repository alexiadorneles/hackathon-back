package br.com.hackathon.utils;

import static br.com.hackathon.constants.Constants.FORBIDDEN_ACTION;
import static br.com.hackathon.constants.Constants.INVALID_DATA;

import java.util.Objects;

import br.com.hackathon.exception.HackathonException;
import br.com.hackathon.model.Usuario;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public class SecurityUtils {
    public static void verifyPrincipal(Usuario principal, Usuario owner) {
        if (Objects.isNull(principal) || Objects.isNull(owner)) {
            throw new RuntimeException(INVALID_DATA);
        }

        if (!principal.getIdUsuario().equals(owner.getIdUsuario())) {
            throw new HackathonException(FORBIDDEN_ACTION);
        }
    }
}
