package br.com.hackathon.controller;

import br.com.hackathon.dto.user.CreateUserDto;
import br.com.hackathon.domain.User;
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
public class UserSecuredController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User exemploSave(@RequestBody CreateUserDto userId) {
        return userService.save(userId);
    }

}
