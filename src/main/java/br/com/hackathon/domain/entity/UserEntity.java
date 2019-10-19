package br.com.hackathon.domain.entity;

import lombok.Getter;

import javax.persistence.*;

/**
 * @author eduardo.thums
 */
@Getter
@Entity
@Table(name = "\"user\"")
public class UserEntity {

	@Id
	@SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
	private Long id;

	private String username;

	private String password;

	private String email;

	private String firstName;

	private String lastName;

	private String cpf;

	private String cnpj;

	private String imageUrl;

	private Long latitude;

	private Long longitude;
}
