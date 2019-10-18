package br.com.hackathon.configuration.security;

import br.com.hackathon.dto.login.LoginResponseDto;
import br.com.hackathon.dto.usuario.UsuarioCadastroDto;
import br.com.hackathon.domain.User;
import br.com.hackathon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Objects;

import static br.com.hackathon.constants.Constants.HEADER_PREFIX;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Inject
    private UserService userService;

    public LoginResponseDto authenticate(UsuarioCadastroDto cadastroDto) {
        User user = userService.findByEmail(cadastroDto.getEmail());
        if (Objects.isNull(user)) user = userService.save(cadastroDto);

        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        cadastroDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Long idUsuario = userPrincipal.getId();

        return LoginResponseDto.builder()
                .accessToken(HEADER_PREFIX + this.tokenProvider.generateToken(authentication))
                .idUsuario(idUsuario)
                .build();
    }
}
