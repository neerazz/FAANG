package weekly.weekly192;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jun 06, 2020
 * Questions: https://leetcode.com/problems/design-browser-history
 */
public class DesignBrowserHistory {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}

class BrowserHistory {
    List<String> list = new ArrayList<>();
    int cur;

    public BrowserHistory(String homepage) {
        list.add(homepage);
        cur = 0;
    }

    public void visit(String url) {
//        If cur is not at the end, then clear all the elements from the index.
        if (cur != list.size() - 1) {
            list.subList(cur + 1, list.size()).clear();
        }
        list.add(url);
        cur++;
    }

    public String back(int steps) {
        cur -= steps;
        if (cur < 0) {
            cur = 0;
        }
        return list.get(cur);
    }

    public String forward(int steps) {
        cur += steps;
        if (cur >= list.size()) {
            cur = list.size() - 1;
        }
        return list.get(cur);
    }
}