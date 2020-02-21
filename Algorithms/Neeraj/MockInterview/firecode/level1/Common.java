package firecode.level1;

import java.util.*;

import static firecode.level1.FindTheMiddleOfAListInASinglePass.createListNode;

public class Common {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacter("abcdcd"));
        System.out.println(deleteAtTail(createListNode(Arrays.asList(1))));
        System.out.println(deleteAtTail(createListNode(Arrays.asList(1, 2))));
        System.out.println(deleteAtTail(createListNode(Arrays.asList(1, 2, 3))));
        System.out.println(deleteAtTail(createListNode(Arrays.asList(1, 2, 3, 4))));
        System.out.println(reverseString("abcde"));
        System.out.println(reverseString("1"));
        System.out.println(reverseString(""));
        System.out.println(reverseString("madam"));
        System.out.println(reverseString(null));
    }

    public static String replace(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char curr = a.charAt(i);
            if (curr == ' ') {
                sb.append(b);
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }

    public static String reverseString(String str) {
        if (str == null || str.isEmpty()) return str;
        String inputString = str;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean areAllCharactersUnique(String str) {
        if (str == null || str.isEmpty()) return true;
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (characters.contains(curr)) return false;
            else characters.add(curr);
        }
        return true;
    }

    public static Character firstNonRepeatedCharacter(String str) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            characterIntegerMap.put(current, characterIntegerMap.getOrDefault(current, 0) + 1);
        }
        return characterIntegerMap.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public static ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode first = head, second = head.next.next;
        while (second != null) {
            second = second.next;
            first = first.next;
        }
        first.next = second;
        return head;
    }

    public ListNode insertAtTail(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) return newNode;
        ListNode first = head, second = head.next;
        while (second != null) {
            second = second.next;
            first = first.next;
        }
        first.next = newNode;
        return head;
    }

    public ListNode deleteAtHead(ListNode head) {
        if (head == null) return head;
        return head.next;
    }
}
