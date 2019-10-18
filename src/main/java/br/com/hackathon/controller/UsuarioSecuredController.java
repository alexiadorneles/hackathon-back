package br.com.hackathon.controller;

import br.com.hackathon.dto.usuario.UsuarioCadastroDto;
import br.com.hackathon.model.User;
import br.com.hackathon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@RestController
@RequestMapping("/user")
public class UsuarioSecuredController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User exemploSave(@RequestBody UsuarioCadastroDto usuario) {
        return userService.save(usuario);
    }

}
