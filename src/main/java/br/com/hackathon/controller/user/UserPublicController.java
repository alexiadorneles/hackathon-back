package br.com.hackathon.controller.user;

import br.com.hackathon.dto.user.CreateUserDto;
import br.com.hackathon.dto.user.RankListUserDto;
import br.com.hackathon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

	@PostMapping
	public ResponseEntity<Long> save(@RequestBody @Valid CreateUserDto request) {
		return new ResponseEntity<>(userService.save(request), HttpStatus.CREATED);
	}
}
