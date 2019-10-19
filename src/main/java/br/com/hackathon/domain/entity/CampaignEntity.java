package br.com.hackathon.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author eduardo.thums
 */
@Entity
@Table(name = "campaign")
public class CampaignEntity {

	@Id
	@SequenceGenerator(name = "campaign_id_seq", sequenceName = "campaign_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campaign_id_seq")
	private Long id;

	private Long organizationId;

	private String title;

	private String description;

	private LocalDateTime startDate;

	private LocalDateTime endDate;
}
