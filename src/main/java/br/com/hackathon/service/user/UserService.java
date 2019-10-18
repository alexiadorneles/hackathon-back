package br.com.hackathon.service.user;

import br.com.hackathon.dto.usuario.UsuarioCadastroDto;
import br.com.hackathon.model.User;

import java.util.List;

public interface UserService {
    User save(UsuarioCadastroDto usuarioCadastroDto);

    User load(Long idUsuario);

    User findByEmail(String email);

    List<User> findAll();

    long count();

    void delete(Long idUsuario);
}
