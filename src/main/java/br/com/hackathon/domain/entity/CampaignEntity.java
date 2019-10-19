package br.com.hackathon.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author eduardo.thums
 */
@Entity
@Table(name = "campaign")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CampaignEntity implements Serializable {

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
