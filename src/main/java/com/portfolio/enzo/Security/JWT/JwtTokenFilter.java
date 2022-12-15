package com.portfolio.enzo.Security.JWT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.portfolio.enzo.Security.Service.ImplUsuarioDetails;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    ImplUsuarioDetails implUsuarioDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getToken(request);
            if (token != null && jwtProvider.validateToken(token)) {
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = implUsuarioDetailService.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(userAuth);

            }
        } catch (Exception e) {
            logger.error("Falló el metodo doFilterInternal");
        }
        filterChain.doFilter(request, response);

    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            return header.replaceAll("Bearer", "");
        }
        return null;
    }
}
