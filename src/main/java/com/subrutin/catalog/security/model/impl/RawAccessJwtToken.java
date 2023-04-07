package com.subrutin.catalog.security.model.impl;

import com.subrutin.catalog.security.model.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.security.Key;

public class RawAccessJwtToken implements Token {

    private final String token;

    public RawAccessJwtToken(String token) {
        this.token = token;
    }

    public Jws<Claims> parseClaims(Key signingKey) {
        return Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token);
    }

    @Override
    public String getToken() {
        return this.token;
    }

}
