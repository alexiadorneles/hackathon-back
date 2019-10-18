package br.com.hackathon.model;

import static br.com.hackathon.constants.Constants.INCORRECT_EMAIL_MESSAGE;
import static br.com.hackathon.constants.Constants.REG_EXP_EMAIL_VALIDATION;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "\"user\"")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_USUARIO", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String idGoogle;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @Pattern(regexp = REG_EXP_EMAIL_VALIDATION, message = INCORRECT_EMAIL_MESSAGE)
    @NotNull
    @Column(name = "DS_EMAIL", nullable = false)
    private String email;

    private String photo;

    @NotNull
    @Column(nullable = false)
    private String password;

    public void encryptPassword() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

}
