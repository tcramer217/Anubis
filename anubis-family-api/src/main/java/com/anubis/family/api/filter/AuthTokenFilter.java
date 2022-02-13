package com.anubis.family.api.filter;

import com.anubis.family.api.service.UserDetailsServiceImpl;
import com.anubis.family.api.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    private JwtUtil jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwt != null && getJwtUtils().validateJwtToken(jwt)) {
                String username = getJwtUtils().getUserNameFromJwtToken(jwt);
                UserDetails userDetails = getUserDetailsService().loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            LOGGER.error("Cannot set user authentication: {}", e);
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        return getJwtUtils().getJwtFromCookies(request);
    }

    public JwtUtil getJwtUtils() {
        return jwtUtils;
    }

    public void setJwtUtils(JwtUtil jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public UserDetailsServiceImpl getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
