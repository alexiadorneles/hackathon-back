package br.com.hackathon.controller.publicurl;

import br.com.hackathon.domain.User;
import br.com.hackathon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@RestController
@RequestMapping("/public/user")
public class UsuarioController {

    @Autowired
    private UserService userService;

    @PostMapping("/find-by-name")
    public User findByName(@RequestBody String email) {
        return this.userService.findByEmail(email);
    }

    @GetMapping("/count")
    public long count() {
        return this.userService.count();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.userService.delete(id);
    }

    @GetMapping()
    public List<User> findAll() {
        return this.userService.findAll();
    }

}
