package br.com.hackathon.controller;

import br.com.hackathon.dto.usuario.UsuarioCadastroDto;
import br.com.hackathon.model.Usuario;
import br.com.hackathon.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hackathon.service.usuario.UsuarioServiceImpl;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@RestController
@RequestMapping("/usuario")
public class UsuarioSecuredController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario exemploSave(@RequestBody UsuarioCadastroDto usuario) {
        return usuarioService.save(usuario);
    }

}
