package com.subrutin.catalog.security.filter;

import com.subrutin.catalog.security.model.impl.AnonymousAuthentication;
import com.subrutin.catalog.security.model.impl.JwtAuthenticationToken;
import com.subrutin.catalog.security.model.impl.RawAccessJwtToken;
import com.subrutin.catalog.util.TokenExtractor;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.io.IOException;

public class JwtAuthProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private final TokenExtractor tokenExtractor;
    private final AuthenticationFailureHandler authenticationFailureHandler;

    protected JwtAuthProcessingFilter(
            RequestMatcher requiresAuthenticationRequestMatcher, TokenExtractor tokenExtractor,
            AuthenticationFailureHandler authenticationFailureHandler) {

        super(requiresAuthenticationRequestMatcher);
        this.tokenExtractor = tokenExtractor;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        String authorizationHeader = request.getHeader("Authorization");
        String jwt = tokenExtractor.extractToken(authorizationHeader);
        RawAccessJwtToken rawToken = new RawAccessJwtToken(jwt);

        return this.getAuthenticationManager().authenticate(new JwtAuthenticationToken(rawToken));

    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response,
            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(authResult);
        SecurityContextHolder.setContext(securityContext);
        chain.doFilter(request, response);

    }

    @Override
    protected void unsuccessfulAuthentication(
            HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        SecurityContextHolder.clearContext();
        SecurityContextHolder.getContext().setAuthentication(new AnonymousAuthentication());
        authenticationFailureHandler.onAuthenticationFailure(request, response, failed);
    }
}
