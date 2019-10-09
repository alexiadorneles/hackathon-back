package br.com.hackathon.service.usuario;

import br.com.hackathon.dto.usuario.UsuarioCadastroDto;
import br.com.hackathon.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save(UsuarioCadastroDto usuarioCadastroDto);

    Usuario load(Long idUsuario);

    Usuario findByDsLogin(String dsLogin);

    List<Usuario> findByName(String nmUsuario);

    List<Usuario> findAll();

    long count();

    void delete(Long idUsuario);
}
