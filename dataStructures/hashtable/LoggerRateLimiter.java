import java.util.HashMap;

/*
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1122/
Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
It is possible that several messages arrive roughly at the same time.
Example:
Logger logger = new Logger();
// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true;
// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;
 */
public class LoggerRateLimiter {
    public static void main(String[] args) {
        Logger logger = new Logger();

// logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo") + " returns true");

// logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2, "bar") + " returns true");

// logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3, "foo") + " returns false");

// logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8, "bar") + " returns false");

// logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10, "foo") + " returns false");

// logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11, "foo") + " returns true");
    }
}

class Logger {

    HashMap<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastProcessed = map.get(message);
        if (lastProcessed != null) {
            if (Math.abs(lastProcessed - timestamp) >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
        map.put(message, timestamp);
        return true;
    }
}