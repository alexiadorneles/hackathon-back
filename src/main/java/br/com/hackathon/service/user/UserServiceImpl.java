package br.com.hackathon.service.user;

import br.com.hackathon.domain.User;
import br.com.hackathon.dto.user.CreateUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Service
public class UserServiceImpl implements UserService {


	@Override
	public User save(CreateUserDto createUserDto) {
		return null;
	}

	@Override
	public User load(Long userId) {
		return null;
	}

	@Override
	public User findByEmail(String email) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}
}
