package br.com.hackathon.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author eduardo.thums
 */
@Setter
@Getter
@Entity
@Table(name = "\"user\"")
@AllArgsConstructor
@NoArgsConstructor
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
