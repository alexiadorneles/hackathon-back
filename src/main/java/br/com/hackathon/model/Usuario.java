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
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_ID_USUARIO", columnNames = "ID_USUARIO"),
                @UniqueConstraint(name = "UK_DS_EMAIL", columnNames = "DS_EMAIL"),
                @UniqueConstraint(name = "UK_DS_LOGIN", columnNames = "DS_LOGIN")
        },
        indexes = {
                @Index(name = "IX_PK_USUARIO", columnList = "ID_USUARIO"),
        }
)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_USUARIO", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    @NotNull
    @Column(nullable = false)
    private String idGoogle;

    @NotNull
    @Column(nullable = false)
    private String nmUsuario;

    @NotNull
    @Column(nullable = false)
    private String dsSobrenome;

    @Pattern(regexp = REG_EXP_EMAIL_VALIDATION, message = INCORRECT_EMAIL_MESSAGE)
    @NotNull
    @Column(name = "DS_EMAIL", nullable = false)
    private String dsEmail;

    @NotNull
    @Column(name = "DS_LOGIN", nullable = false)
    private String dsLogin;

    @NotNull
    @Column(nullable = false)
    private String dsSenha;

    @Column
    private String dsFoto;

    public String getFullName() {
        return String.format("%s %s", this.getNmUsuario(), this.getDsSobrenome());
    }

    public void encryptPassword() {
        this.dsSenha = new BCryptPasswordEncoder().encode(this.dsSenha);
    }

}
