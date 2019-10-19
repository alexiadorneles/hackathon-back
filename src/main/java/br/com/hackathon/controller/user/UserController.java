package br.com.hackathon.controller.user;

import br.com.hackathon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
}
