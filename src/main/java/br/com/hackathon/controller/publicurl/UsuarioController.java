package br.com.hackathon.controller.publicurl;

import java.util.List;

import br.com.hackathon.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hackathon.model.Usuario;
import br.com.hackathon.service.usuario.UsuarioServiceImpl;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@RestController
@RequestMapping("/public/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/find-by-name")
    public Iterable<Usuario> findByName(@RequestBody String name) {
        return this.usuarioService.findByName(name);
    }

    @GetMapping("/count")
    public long count() {
        return this.usuarioService.count();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.usuarioService.delete(id);
    }

    @GetMapping()
    public List<Usuario> findAll() {
        return this.usuarioService.findAll();
    }

}
