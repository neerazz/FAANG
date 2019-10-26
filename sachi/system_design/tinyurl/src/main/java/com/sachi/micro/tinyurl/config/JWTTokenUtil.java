package com.sachi.micro.tinyurl.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import java.util.function.Function;

@Component
public class JWTTokenUtil implements Serializable {

    private final ResourceLoader resourceLoader;

    private static final long serialVersionUID = -2550185165626007488L;

    public JWTTokenUtil(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    public String getUserNameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(getPublicKey().get()).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        //Header
        Header header = Jwts.header();
        header.setType("JWT");
        //Date
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.YEAR, 1);
        Date expiryDate = calendar.getTime();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setHeader((Map<String, Object>) header)
                .setIssuedAt(today)
                .setExpiration(expiryDate)
                .signWith(getPrivateKey().get())
                .compact();
    }

    /**
     * Read Private File from resources dir
     *
     * @return PrivateKey privateKey
     */
    private Optional<PrivateKey> getPrivateKey() {
        try {
            File privateKeyFile = resourceLoader.getResource("classpath:key.pem").getFile();
            PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
            Object object = pemParser.readObject();
            KeyPair kp = converter.getKeyPair((PEMKeyPair) object);
            return Optional.of(kp.getPrivate());
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * Read public key from file
     *
     * @return PublicKey publicKey
     */
    private Optional<PublicKey> getPublicKey() {
        try {
            byte[] publicKeyBytes = this.getClass().getClassLoader().getResourceAsStream("certificate.pem").readAllBytes();
            X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return Optional.of(kf.generatePublic(publicSpec));
        } catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
