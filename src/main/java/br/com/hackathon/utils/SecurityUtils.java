package br.com.hackathon.utils;

import br.com.hackathon.exception.HackathonException;
import br.com.hackathon.model.User;

import java.util.Objects;

import static br.com.hackathon.constants.Constants.FORBIDDEN_ACTION;
import static br.com.hackathon.constants.Constants.INVALID_DATA;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public class SecurityUtils {
    public static void verifyPrincipal(User principal, User owner) {
        if (Objects.isNull(principal) || Objects.isNull(owner)) {
            throw new RuntimeException(INVALID_DATA);
        }

        if (!principal.getId().equals(owner.getId())) {
            throw new HackathonException(FORBIDDEN_ACTION);
        }
    }
}
