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
@Table(name = "organization")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrganizationEntity implements Serializable {

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

	private String imageUrl;
}
