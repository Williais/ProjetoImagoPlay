package com.imagoPlay.ProjetoImagoPlay.config;

import com.imagoPlay.ProjetoImagoPlay.modules.users.repository.UserRepository;
import com.imagoPlay.ProjetoImagoPlay.modules.users.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    public final TokenService tokenService;
    public final UserRepository userRepository;

    public SecurityFilter(TokenService t, UserRepository r){
        this.tokenService = t;
        this.userRepository = r;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var token = recoverToken(request);

        if (token != null){
            String email = tokenService.validarToken(token);

            if (email != null && !email.isEmpty()){
                var user = userRepository.findByEmail(email).orElse(null);

                if (user != null){

                    var authentication = new UsernamePasswordAuthenticationToken(user, null, null);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        String auth = request.getHeader("Authorization");

        if(auth == null || !auth.startsWith("Bearer ")){
            return null;
        }else{
            return auth.replace("Bearer ", "");
        }
    }

}
