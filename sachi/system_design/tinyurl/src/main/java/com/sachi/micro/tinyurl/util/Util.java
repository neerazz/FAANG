package com.sachi.micro.tinyurl.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class Util {

    private static String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890";

    public static String generateHash(String url, String userId) {
        StringBuilder hashFunction = new StringBuilder();
        try {
            String salt = getRandomString(10) + userId;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(salt.getBytes());
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

    public static String generateHash(String customSalt) {
        String apiKey = null;
        customSalt = StringUtils.isEmpty(customSalt) ? getRandomString(50) : customSalt;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(customSalt.getBytes());
            byte[] bytes = messageDigest.digest(getRandomString(100).getBytes());
            apiKey = Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        log.debug("Key is" + apiKey);
        return apiKey;
    }

    private static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }
        return sb.toString();
    }

    public static Date convertLocalToUTC(Date utcTime) {
        return new Date(utcTime.getTime() - Calendar.getInstance().getTimeZone().getOffset(utcTime.getTime()));

    }

    public static Date dateFromUTC(Date localTime) {
        return new Date(localTime.getTime() + Calendar.getInstance().getTimeZone().getOffset(localTime.getTime()));
    }
}
