package com.subrutin.catalog.util.impl;

import com.subrutin.catalog.util.TokenExtractor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;

@Component
public class JWTHeaderTokenExtractor  implements TokenExtractor {

    private static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";

    @Override
    public String extractToken(String payload) {

        if (StringUtils.isBlank(payload)) {
            throw new AuthenticationServiceException("Invalid JWT Token");
        }

        if (payload.length() < AUTHORIZATION_HEADER_PREFIX.length()) {
            throw new AuthenticationServiceException("Invalid JWT Token");
        }

        return payload.substring(AUTHORIZATION_HEADER_PREFIX.length());

    }

}
