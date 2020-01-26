package problems.systemdesign;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/encode-and-decode-tinyurl/";
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode(url)) + " should be : " + url);
    }
}

class Codec {

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final String PREFIX = "http://tinyurl.com/";
    Map<String, String> urlMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int length = 3;
        String randomShortURL = generateRandomString(length);
        while (urlMap.containsKey(randomShortURL)) {
            randomShortURL = generateRandomString(length++);
        }
        randomShortURL = PREFIX + randomShortURL;
        urlMap.put(randomShortURL, longUrl);
        return randomShortURL;
    }

    private String generateRandomString(int length) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder randStr = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = secureRandom.nextInt(CHAR_LIST.length());
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.getOrDefault(shortUrl, null);
    }
}