package br.com.hackathon.dto.campaignitem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author eduardo.thums
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampaignItemDto {

	private Long id;

	private Long itemId;

	private String title;

	private String description;

	private Integer quantity;

	private Boolean isCompleted;
}
