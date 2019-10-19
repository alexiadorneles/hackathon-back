package br.com.hackathon.mapper;

import br.com.hackathon.domain.entity.UserEntity;
import br.com.hackathon.dto.user.CreateUserDto;
import br.com.hackathon.dto.user.RankUserDto;
import br.com.hackathon.projection.RankUserDtoProjection;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author eduardo.thums
 */
@Component
public class UserMapper {

	public List<RankUserDto> toRankUserDtos(List<RankUserDtoProjection> rankUserDtoProjections) {
		return rankUserDtoProjections
				.stream()
				.map(rankUserDtoProjection ->
						RankUserDto
								.builder()
								.fullName(rankUserDtoProjection.getFullName())
								.cnpj(rankUserDtoProjection.getCnpj())
								.cpf(rankUserDtoProjection.getCpf())
								.imageUrl(rankUserDtoProjection.getImageUrl())
								.build())
				.collect(Collectors.toList());
	}

	public UserEntity fromCreateUserDto(CreateUserDto createUserDto) {
		final UserEntity userEntity = new UserEntity();
		userEntity.setUsername(createUserDto.getEmail());
		userEntity.setEmail(createUserDto.getEmail());
		userEntity.setPassword(createUserDto.getPassword());
		userEntity.setFirstName(createUserDto.getFirstName());
		userEntity.setLastName(createUserDto.getLastName());
		userEntity.setImageUrl("https://scontent.fpoa10-1.fna.fbcdn.net/v/t1.0-9/72984156_1125137077689442_1938343638610214912_n.jpg?_nc_cat=105&_nc_oc=AQkPRGeLeFloc_qFxTu448F9V7XxIVLz56SqulfLB9alWLk8KS_8inTqg19cua60l1U&_nc_ht=scontent.fpoa10-1.fna&oh=2d0859b7b70bbd749cd62ed7924dceea&oe=5E6260FF");
		userEntity.setCpf(createUserDto.getCpf());
		userEntity.setCnpj(createUserDto.getCnpj());
		userEntity.setLatitude(createUserDto.getLatitude());
		userEntity.setLongitude(createUserDto.getLongitude());

		return userEntity;
	}
}
