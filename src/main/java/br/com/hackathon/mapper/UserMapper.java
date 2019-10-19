package br.com.hackathon.mapper;

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
}
