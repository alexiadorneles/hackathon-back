package br.com.hackathon.configuration.security;

import static br.com.hackathon.constants.Constants.HEADER_PREFIX;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		this.tokenProvider.getUserId(this.getJwt(request)).ifPresent(id -> {
			UserDetails user = this.customUserDetailsService.loadUserById(id);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			SecurityContextHolder.getContext().setAuthentication(authentication);
		});

		filterChain.doFilter(request, response);
	}

	private String getJwt(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		return StringUtils.hasText(token) && token.startsWith(HEADER_PREFIX)
				? token.substring(7, token.length()) : null;
	}
}