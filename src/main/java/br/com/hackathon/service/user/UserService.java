package br.com.hackathon.service.user;

import br.com.hackathon.domain.entity.UserEntity;
import br.com.hackathon.dto.user.CreateUserDto;
import br.com.hackathon.dto.user.RankListUserDto;
import br.com.hackathon.service.CRUDService;

public interface UserService extends CRUDService<UserEntity, Long> {

	Long save(CreateUserDto request);

	RankListUserDto listUsersRank();
}
