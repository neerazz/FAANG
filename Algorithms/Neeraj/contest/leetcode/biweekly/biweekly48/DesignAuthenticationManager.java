package biweekly.biweekly48;

import java.util.*;

/**
 * Created on:  Mar 20, 2021
 * Questions:
 */

public class DesignAuthenticationManager {

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5); // Constructs the AuthenticationManager with timeToLive = 5 seconds.
        authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
        authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
        authenticationManager.countUnexpiredTokens(6); // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
        authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
        authenticationManager.renew("aaa", 8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing happens.
        authenticationManager.renew("bbb", 10); // The token with tokenId "bbb" is unexpired at time 10, so the renew request is fulfilled and now the token will expire at time 15.
        authenticationManager.countUnexpiredTokens(15); // The token with tokenId "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so currently no token is unexpired, so return 0.
    }

    static class AuthenticationManager {
        Queue<Token> queue = new LinkedList<>();
        Map<String, Token> map = new HashMap<>();
        int maxtime;

        public AuthenticationManager(int timeToLive) {
            maxtime = timeToLive;
        }

        private void removeExpired(int currentTime) {
            while (!queue.isEmpty() && queue.peek().time + maxtime <= currentTime) {
                map.remove(queue.poll().token);
            }
        }

        public void generate(String tokenId, int currentTime) {
            removeExpired(currentTime);
            addNewToken(tokenId, currentTime);
        }

        private void addNewToken(String tokenId, int currentTime) {
            Token token = new Token(tokenId, currentTime);
            map.put(token.token, token);
            queue.add(token);
        }

        public void renew(String tokenId, int currentTime) {
            removeExpired(currentTime);
            if (map.containsKey(tokenId)) {
                Token token = map.get(tokenId);
                queue.remove(token);
                addNewToken(tokenId, currentTime);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            removeExpired(currentTime);
            return queue.size();
        }
    }

    static class Token {
        String token;
        int time;

        public Token(String token, int time) {
            this.token = token;
            this.time = time;
        }
    }
}
