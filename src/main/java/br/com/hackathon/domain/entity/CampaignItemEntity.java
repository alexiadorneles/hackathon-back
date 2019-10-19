package br.com.hackathon.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author eduardo.thums
 */
@Entity
@Table(name = "campaign_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CampaignItemEntity implements Serializable {

	@Id
	@SequenceGenerator(name = "campaign_item_id_seq", sequenceName = "campaign_item_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campaign_item_id_seq")
	private Long id;

	private Long campaignId;

	private Long itemId;

	private Integer quantity;

	private Boolean isCompleted;
}
