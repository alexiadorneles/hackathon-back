package br.com.hackathon.controller.user;

import br.com.hackathon.dto.user.RankListUserDto;
import br.com.hackathon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eduardo.thums
 */
@RestController
@RequestMapping("public/user")
public class UserPublicController {

	@Autowired
	UserService userService;

	@GetMapping("/rank")
	public ResponseEntity<RankListUserDto> listUsersRank() {
		return ResponseEntity.ok(userService.listUsersRank());
	}
}
