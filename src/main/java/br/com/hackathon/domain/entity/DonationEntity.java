package br.com.hackathon.domain.entity;

import br.com.hackathon.domain.status.DonateStatus;
import br.com.hackathon.domain.type.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author eduardo.thums
 */
@Entity
@Table(name = "donation")
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
public class DonationEntity {

	@Id
	@SequenceGenerator(name = "donation_id_seq", sequenceName = "donation_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donation_id_seq")
	private Long id;

	private Long userId;

	private Long itemId;

	private Long campaignId;

	private Integer quantity;

	private LocalDateTime createdDate;

	@Type(type = "pgsql_enum")
	@Enumerated(EnumType.STRING)
	private DonateStatus status;
}
