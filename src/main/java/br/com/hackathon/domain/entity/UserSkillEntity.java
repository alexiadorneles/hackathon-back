package br.com.hackathon.domain.entity;

import br.com.hackathon.domain.type.PostgreSQLEnumType;
import br.com.hackathon.domain.type.SkillType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author eduardo.thums
 */
@Entity
@Table(name = "user_skill")
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSkillEntity implements Serializable {

	@Id
	@SequenceGenerator(name = "user_skill_id_seq", sequenceName = "user_skill_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_skill_id_seq")
	private Long id;

	private Long userId;

	@Type(type = "pgsql_enum")
	@Enumerated(EnumType.STRING)
	private SkillType skill;
}
