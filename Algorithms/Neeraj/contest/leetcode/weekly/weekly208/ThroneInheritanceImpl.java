package weekly.weekly208;

import java.util.*;

/**
 * Created on:  Sep 26, 2020
 * Questions: https://leetcode.com/problems/throne-inheritance
 */
public class ThroneInheritanceImpl {
    public static void main(String[] args) {
        ThroneInheritance inheritance = new ThroneInheritance("king");
        inheritance.birth("king", "andy");
        inheritance.birth("king", "bob");
        inheritance.birth("king", "catherine");
        inheritance.birth("andy", "matthew");
        inheritance.birth("bob", "alex");
        inheritance.birth("bob", "asha");
        System.out.println(inheritance.getInheritanceOrder());
        inheritance.death("bob");
        System.out.println(inheritance.getInheritanceOrder());
    }

    static class ThroneInheritance {

        Map<String, Node> map;
        String firstKing;

        public ThroneInheritance(String kingName) {
            map = new HashMap<>();
            Node king = new Node(null, kingName);
            map.put(kingName, king);
            firstKing = kingName;
        }

        public void birth(String parentName, String childName) {
            Node parent = map.get(parentName);
            Node child = new Node(parent, childName);
            map.put(childName, child);
            parent.child.add(child);
        }

        public void death(String name) {
            map.get(name).alive = false;
        }

        public List<String> getInheritanceOrder() {
            List<String> op = new ArrayList<>();
            Set<String> kings = new HashSet<>();
            dfs(firstKing, map, op, kings);
            return op;
        }

        private void dfs(String king, Map<String, Node> map, List<String> op, Set<String> kings) {
            Node node = map.get(king);
            if (node.alive) {
                op.add(node.name);
            }
            kings.add(node.name);
//            Loop through all the children's.
            for (Node child : node.child) {
                if (kings.contains(child.name)) continue;
                dfs(child.name, map, op, kings);
            }
        }

        static class Node {
            Node parent;
            String name;
            boolean alive;
            List<Node> child;

            public Node(Node parent, String name) {
                this.parent = parent;
                this.name = name;
                alive = true;
                child = new ArrayList<>();
            }
        }
    }

}
