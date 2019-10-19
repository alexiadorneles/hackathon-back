package br.com.hackathon.service.user;

import br.com.hackathon.domain.entity.UserEntity;
import br.com.hackathon.service.GenericCRUDService;
import org.springframework.stereotype.Service;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Service
public class UserServiceImpl extends GenericCRUDService<UserEntity, Long> implements UserService {


}
