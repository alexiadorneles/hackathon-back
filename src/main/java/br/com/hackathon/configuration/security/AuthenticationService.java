package br.com.hackathon.configuration.security;

import static br.com.hackathon.constants.Constants.HEADER_PREFIX;

import java.util.Objects;
import javax.inject.Inject;

import br.com.hackathon.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.hackathon.dto.login.LoginResponseDto;
import br.com.hackathon.dto.usuario.UsuarioCadastroDto;
import br.com.hackathon.model.Usuario;
import br.com.hackathon.service.usuario.UsuarioServiceImpl;

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
    private UsuarioService usuarioService;

    public LoginResponseDto authenticate(UsuarioCadastroDto cadastroDto) {
        Usuario usuario = usuarioService.findByDsLogin(cadastroDto.getEmail());
        if (Objects.isNull(usuario)) usuario = usuarioService.save(cadastroDto);

        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        usuario.getDsEmail(),
                        cadastroDto.generatePassword()
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
