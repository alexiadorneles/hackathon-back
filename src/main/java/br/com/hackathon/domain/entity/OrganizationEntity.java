package br.com.hackathon.domain.entity;

import javax.persistence.*;

/**
 * @author eduardo.thums
 */
@Entity
@Table(name = "organization")
public class OrganizationEntity {

	@Id
	@SequenceGenerator(name = "organization_id_seq", sequenceName = "organization_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_id_seq")
	private Long id;

	private String username;

	private String password;

	private String email;

	private String name;

	private String description;

	private String cnpj;

	private Long latitude;

	private Long longitude;
}
