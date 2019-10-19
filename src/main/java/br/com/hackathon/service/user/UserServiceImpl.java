package br.com.hackathon.service.user;

import br.com.hackathon.domain.entity.UserEntity;
import br.com.hackathon.dto.user.CreateUserDto;
import br.com.hackathon.dto.user.RankListUserDto;
import br.com.hackathon.dto.user.RankUserDto;
import br.com.hackathon.exception.CnpjAlreadyUsedException;
import br.com.hackathon.exception.CpfAlreadyUsedException;
import br.com.hackathon.exception.EmailAlreadyUsedException;
import br.com.hackathon.mapper.UserMapper;
import br.com.hackathon.repository.UserRepository;
import br.com.hackathon.service.GenericCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Long save(CreateUserDto request) {
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new EmailAlreadyUsedException();
		}

		if (request.getCpf() != null && userRepository.existsByCpf(request.getCpf())) {
			throw new CpfAlreadyUsedException();
		}

		if (request.getCnpj() != null && userRepository.existsByCnpj(request.getCnpj())) {
			throw new CnpjAlreadyUsedException();
		}

		final UserEntity userEntity = userMapper.fromCreateUserDto(request);
		userEntity.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));

		return userRepository.saveAndFlush(userEntity).getId();
	}

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
