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
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemEntity implements Serializable {

	@Id
	@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
	private Long id;

	private String title;

	private String description;
}
