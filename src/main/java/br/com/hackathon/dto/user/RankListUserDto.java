package br.com.hackathon.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author eduardo.thums
 */
@Getter
@Builder
@AllArgsConstructor
public class RankListUserDto {

	private List<RankUserDto> volunteers;

	private List<RankUserDto> companies;
}
