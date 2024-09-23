package com.vidyudabhi.Userserv.config;

import com.vidyudabhi.Userserv.domain.user.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException
    {
        final String authHeader = request.getHeader("Authorization");
        String jwtToken=null;
        String username=null;

        if(authHeader !=null && authHeader.startsWith("Bearer ")){
        jwtToken=authHeader.substring(7);
        username = jwtUtils.extractUsername(jwtToken);
        }

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            if(jwtUtils.isTokenValid(jwtToken,username)){
                System.out.println(username);
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(username,null,null)
                );
            }
        }
        filterChain.doFilter(request,response);
    }


}
