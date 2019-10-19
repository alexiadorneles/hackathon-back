package br.com.hackathon.dto.campaign;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

/**
 * @author eduardo.thums
 */
@Builder
@AllArgsConstructor
public class CampaignDetailsDto {

	private Long id;

	private Long organizationId;

	private String title;

	private String description;

	private LocalDateTime startDate;

	private LocalDateTime endDate;
}
