package br.com.hackathon.service.user;

import br.com.hackathon.dto.user.CreateUserDto;
import br.com.hackathon.domain.User;

import java.util.List;

public interface UserService {
    User save(CreateUserDto createUserDto);

    User load(Long userId);

    User findByEmail(String email);

    List<User> findAll();

    long count();

    void delete(Long userId);
}
