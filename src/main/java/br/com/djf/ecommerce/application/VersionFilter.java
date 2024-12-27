package br.com.djf.ecommerce.application;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class VersionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String sVersion = request.getHeader("appVersion");
        Double version = sVersion != null && !sVersion.trim().isEmpty() ? Double.valueOf(sVersion): 0.0;
        System.out.println(version);
        if(version < 123){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token invalido ou expirado");
        }else{
            filterChain.doFilter(request,response);
        }
    }
}
