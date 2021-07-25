package weekly.weekly251;

import java.util.*;

/**
 * Created on:  Jul 24, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-251/problems/delete-duplicate-folders-in-system/
 */
public class DeleteDuplicateFoldersInSystem {
    public static void main(String[] args) {
        System.out.println(deleteDuplicateFolder(Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("c"),
                Arrays.asList("d"),
                Arrays.asList("a", "b"),
                Arrays.asList("c", "b"),
                Arrays.asList("d", "a")
        )));
    }

    public static List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
//         Tree Creation
        Folder root = new Folder("");
        for (List<String> path : paths) {
            addFolder(root, path);
        }
        Map<String, Integer> keys = new HashMap<>();
        generateKeys(keys, root);
        updateDeletes(keys, root);
        List<List<String>> result = new ArrayList<>();
        for (Folder dep : root.deps.values()) {
            refresh(dep, result, new LinkedList<>());
        }
        return result;
    }

    static void refresh(Folder root, List<List<String>> result, LinkedList<String> soFar) {
        if (root.delete) return;
        soFar.add(root.name);
        result.add(new ArrayList<>(soFar));
        for (Folder dep : root.deps.values()) {
            refresh(dep, result, soFar);
        }
        soFar.removeLast();
    }

    static void updateDeletes(Map<String, Integer> keys, Folder root) {
        for (Folder dep : root.deps.values()) {
            updateDeletes(keys, dep);
        }
        root.delete = keys.getOrDefault(root.key, 0) > 1;
    }

    static String generateKeys(Map<String, Integer> keys, Folder root) {
        StringBuilder sb = new StringBuilder();
        for (Folder dep : root.deps.values()) {
            sb.append("(");
            sb.append(generateKeys(keys, dep));
            sb.append(")");
        }
        if (sb.isEmpty()) return root.name;
        String key = sb.toString();
        root.key = key;
        keys.put(key, keys.getOrDefault(key, 0) + 1);
        sb.append(root.name);
        return sb.toString();
    }

    static void addFolder(Folder folder, List<String> path) {
        Folder pre = folder;
        for (String name : path) {
            Folder cur = pre.get(name);
            if (cur == null) {
                cur = new Folder(name);
                pre.add(cur);
            }
            pre = cur;
        }
    }

    static class Folder {
        String name;
        LinkedHashMap<String, Folder> deps = new LinkedHashMap<>();
        String key;
        boolean delete;

        Folder(String name) {
            this.name = name;
        }

        Folder get(String name) {
            return deps.get(name);
        }

        void add(Folder folder) {
            deps.put(folder.name, folder);
        }

        @Override
        public String toString() {
            return "Folder{" +
                    "name='" + name + '\'' +
                    ", deps=" + deps +
                    ", key='" + key + '\'' +
                    ", delete=" + delete +
                    '}';
        }
    }
}
