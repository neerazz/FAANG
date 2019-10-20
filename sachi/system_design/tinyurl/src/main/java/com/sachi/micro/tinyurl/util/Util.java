package com.sachi.micro.tinyurl.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Util {

    public static String generateHash(String url, String userId) {
        StringBuilder hashFunction = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(userId.getBytes());
            byte[] bytes = messageDigest.digest(url.getBytes(StandardCharsets.UTF_8));
            String hashedCode = Base64.getEncoder().encodeToString(bytes);
            SecureRandom random = new SecureRandom();
            for (int i = 0; i < 6; i++) {
                hashFunction.append(hashedCode.charAt(random.nextInt(hashedCode.length())));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashFunction.toString();
    }
}
