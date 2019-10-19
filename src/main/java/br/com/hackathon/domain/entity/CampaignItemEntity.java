package br.com.hackathon.domain.entity;

import javax.persistence.*;

/**
 * @author eduardo.thums
 */
@Entity
@Table(name = "campaign_item")
public class CampaignItemEntity {

	@Id
	@SequenceGenerator(name = "campaign_item_id_seq", sequenceName = "campaign_item_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campaign_item_id_seq")
	private Long id;

	private Long campaignId;

	private Long itemId;

	private Integer quantity;

	private Boolean isCompleted;
}
