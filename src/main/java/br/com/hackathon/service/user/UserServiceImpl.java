package br.com.hackathon.service.user;

import br.com.hackathon.domain.entity.UserEntity;
import br.com.hackathon.dto.user.RankListUserDto;
import br.com.hackathon.dto.user.RankUserDto;
import br.com.hackathon.mapper.UserMapper;
import br.com.hackathon.repository.UserRepository;
import br.com.hackathon.service.GenericCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Service
public class UserServiceImpl extends GenericCRUDService<UserEntity, Long> implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public RankListUserDto listUsersRank() {
		final List<RankUserDto> rankUserDtos = userMapper.toRankUserDtos(userRepository.listUsersRank());

		final List<RankUserDto> volunteers = rankUserDtos
				.stream()
				.filter(rankUserDto -> rankUserDto.getCpf() != null)
				.collect(Collectors.toList());

		final List<RankUserDto> companies = rankUserDtos
				.stream()
				.filter(rankUserDto -> rankUserDto.getCnpj() != null)
				.collect(Collectors.toList());

		return RankListUserDto
				.builder()
				.volunteers(volunteers)
				.companies(companies)
				.build();
	}
}
