import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Sep 25, 2021
 * Ref: https://start.interviewing.io/interview/rTEpur51W0Pf/replay
 */
public class PrintFileStructure {
    public static void main(String[] args) {
        printFiles(new String[]{
                "/webapp/asserts/html/a.html",
                "/webapp/asserts/html/b.html",
                "/webapp/asserts/html/c.html",
                "/webapp/asserts/js/d.js",
                "/webapp/asserts/js/e.js",
                "/webapp/asserts/css/f/f.css",
                "/webapp/asserts/css/g/g.css",
                "/webapp/resources/image/h.jpg",
                "/webapp/resources/image/i.jpg",
                "/webapp/resources/gif/j.gif",
                "/webapp/static/k.gif",
                "/webapp/l.gif",
                "/m.gif"});
    }

    private static void printFiles(String[] files) {
        Dir dir = new Dir("/", 0);
        for (String file : files) {
            String[] split = file.split("/");
            buildTree(split, dir);
        }
        dfs(dir);
    }

    private static void dfs(Dir dir) {
        if (dir.level != 0) {
            System.out.println(getTab(dir.level) + " -- " + dir.name);
        }
        for (Dir next : dir.dirs.values()) {
            dfs(next);
        }
    }

    private static String getTab(int level) {
        StringBuilder sb = new StringBuilder();
        while (level-- > 0) sb.append("  ");
        return sb.toString();
    }

    private static void buildTree(String[] names, Dir dir) {
        Dir cur = dir;
        for (String name : names) {
            if (name.length() == 0) continue;
            Dir next = cur.getDir(name);
            if (next == null) {
                next = new Dir(name, cur.level + 1);
            }
            cur.addDir(next);
            cur = next;
        }
    }

    static class Dir {
        String name;
        int level;
        Map<String, Dir> dirs;

        Dir(String name, int level) {
            this.name = name;
            this.level = level;
            dirs = new HashMap<>();
        }

        Dir getDir(String name) {
            return dirs.get(name);
        }

        void addDir(Dir dir) {
            dirs.put(dir.name, dir);
        }
    }
}
