package br.com.hackathon.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author eduardo.thums
 */
@Entity
@Table(name = "event")
public class EventEntity {

	@Id
	@SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
	private Long id;

	private Long campaignId;

	private String title;

	private String description;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private Long latitude;

	private Long longitude;
}
