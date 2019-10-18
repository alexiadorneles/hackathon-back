package br.com.hackathon.domain;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import static br.com.hackathon.constants.Constants.INCORRECT_EMAIL_MESSAGE;
import static br.com.hackathon.constants.Constants.REG_EXP_EMAIL_VALIDATION;

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
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @Pattern(regexp = REG_EXP_EMAIL_VALIDATION, message = INCORRECT_EMAIL_MESSAGE)
    @NotNull
    @Column(nullable = false)
    private String email;

    private String photo;

    @NotNull
    @Column(nullable = false)
    private String password;

    public void encryptPassword() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

}
