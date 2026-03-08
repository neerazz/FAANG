import java.util.*;

/**
 * Created on:  Oct 13, 2021
 * Ref:
 */
public class GoogleR2 {
    public static void main(String[] args) {
    }
    //Gro to the algorithm of generating. That is what she wants.
    //https://leetcode.com/problems/encode-and-decode-tinyurl/solution/

    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();
    String key = getRand();

    public String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://bit.ly/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://bit.ly/", ""));
    }





}
