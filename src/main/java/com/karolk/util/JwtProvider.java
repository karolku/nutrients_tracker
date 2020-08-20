package com.karolk.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class JwtProvider {
    private String SECRET_KEY = "dkd32Gsuyw1kft7nbfWsdg638XfwUoIsDB5D1tw";
    private long nowInMillis = System.currentTimeMillis();
    Date issueDate = new Date(nowInMillis);
    long fiveHoursMillis = 1000 * 60 * 60 * 5;
    Date fiveHoursFromNow = new Date(nowInMillis + fiveHoursMillis);

    public String createToken(Map<String,Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(issueDate)
                .setExpiration(fiveHoursFromNow)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
