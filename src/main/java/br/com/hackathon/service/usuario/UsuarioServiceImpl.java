package br.com.hackathon.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hackathon.dto.usuario.UsuarioCadastroDto;
import br.com.hackathon.mapper.usuario.UsuarioMapper;
import br.com.hackathon.model.Usuario;
import br.com.hackathon.repository.UsuarioRepository;
import br.com.hackathon.service.AbstractService;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Service
public class UsuarioServiceImpl extends AbstractService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario save(UsuarioCadastroDto usuarioCadastroDto) {
		Usuario model = UsuarioMapper.fromCadastroDtoToModel(usuarioCadastroDto);
		model.encryptPassword();
		return repository.save(model);
	}

	public Usuario load(Long idUsuario) {
		return this.repository.findOne(idUsuario);
	}

	public Usuario findByDsLogin(String dsLogin) {
		return repository.findByDsLogin(dsLogin).orElse(null);
	}

	public List<Usuario> findByName(String nmUsuario) {
		return this.repository.findByNmUsuario(nmUsuario);
	}

	public List<Usuario> findAll() {
		return this.repository.findAll();
	}

	public long count() {
		return this.repository.count();
	}

	public void delete(Long idUsuario) {
		this.repository.delete(idUsuario);
	}

}
