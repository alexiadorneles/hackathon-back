package br.com.hackathon.service.user;

import br.com.hackathon.dto.user.CreateUserDto;
import br.com.hackathon.mapper.user.UserMapper;
import br.com.hackathon.domain.User;
import br.com.hackathon.repository.UserRepository;
import br.com.hackathon.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Service
public class UserServiceImpl extends AbstractService {

	@Autowired
	private UserRepository repository;

	public User save(CreateUserDto createUserDto) {
		User model = UserMapper.fromCadastroDtoToModel(createUserDto);
		model.encryptPassword();
		return repository.save(model);
	}

	public User load(Long idUser) {
		return this.repository.findOne(idUser);
	}

	public User findByEmail(String dsLogin) {
		return repository.findByEmail(dsLogin).orElse(null);
	}

	public List<User> findAll() {
		return this.repository.findAll();
	}

	public long count() {
		return this.repository.count();
	}

	public void delete(Long idUser) {
		this.repository.delete(idUser);
	}

}
