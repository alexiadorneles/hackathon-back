package br.com.hackathon.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author eduardo.thums
 */
@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

	@Id
	@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
	private Long id;

	private String title;

	private String description;
}
