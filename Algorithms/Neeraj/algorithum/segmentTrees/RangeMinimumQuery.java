import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Jan 11, 2021
 * Questions: https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/tutorial/
 */

public class RangeMinimumQuery {

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
//        FastReader fr = new FastReader(new URL("https://he-s3.s3.amazonaws.com/media/hackathon/question-for-new-practice-section/problems/2bb3a09c-0-input-2bb345b.txt?Signature=0EhtKKlBU1EYPTbK9lNM%2Bj8TnpU%3D&Expires=1610405561&AWSAccessKeyId=AKIA6I2ISGOYH7WWS3G5"));
        int n = fr.nextInt(), q = fr.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = fr.nextInt();
        }
        int[][] queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            String[] cur = fr.readLine().split(" ");
            queries[i] = new int[]{cur[0].equals("q") ? 1 : 2, Integer.parseInt(cur[1]), Integer.parseInt(cur[1])};
        }
        int[] result = getRangeMin(nums, queries);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] getRangeMin(int[] nums, int[][] queries) {
        STree sTree = new STree(nums);
        List<Integer> list = new ArrayList<>();
        for (int[] cur : queries) {
            if (cur[0] == 1) {
                list.add(sTree.getMinVal(cur[1], cur[2]));
            } else {
                sTree.update(cur[1] - 1, cur[2]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    static class STree {
        int[] tree, nums;

        STree(int[] nums) {
            int len = nums.length;
            tree = new int[4 * len];
            this.nums = nums;
            buildSTree(nums, 0, len - 1, 0);
        }

        private void buildSTree(int[] nums, int start, int end, int idx) {
            if (start == end) {
                tree[idx] = nums[start];
            } else {
                int mid = (start + end) / 2;
                int left = 2 * idx + 1, right = 2 * idx + 2;
                buildSTree(nums, start, mid, left);
                buildSTree(nums, mid + 1, end, right);
                tree[idx] = Math.min(tree[left], tree[right]);
            }
        }

        public void update(int idx, int to) {
            nums[idx] = to;
            updateSTree(idx, 0, nums.length - 1, 0, to);
        }

        private void updateSTree(int idx, int start, int end, int sIdx, int to) {
            if (start == end) {
                tree[sIdx] = to;
            } else {
//            If the index is in the left side.
                int mid = (start + end) / 2;
                int left = 2 * idx + 1, right = 2 * idx + 2;
                if (start <= idx && idx <= mid) {
//                If the update index is in the left side
                    updateSTree(idx, start, mid, left, to);
                } else {
//                If the update index is in the right side
                    updateSTree(idx, mid + 1, end, right, to);
                }
                tree[idx] = Math.min(tree[left], tree[right]);
            }
        }

        public int getMinVal(int from, int to) {
            return getSTreeVal(from - 1, to - 1, 0, nums.length - 1, 0);
        }

        private int getSTreeVal(int from, int to, int start, int end, int idx) {
            if (to < start || from > end) return Integer.MAX_VALUE;
            if (start >= from && end <= to) return tree[idx];
            int mid = (start + end) / 2;
            int left = getSTreeVal(from, to, start, mid, 2 * idx + 1);
            int right = getSTreeVal(from, to, mid + 1, end, 2 * idx + 2);
            return Math.min(left, right);
        }
    }
}

class FastReader {
    private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public FastReader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public FastReader(URL url) throws IOException {
        URLConnection connections = url.openConnection();
        din = new DataInputStream(connections.getInputStream());
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public FastReader(String file_name) {
        try {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLine() {
        StringBuilder sb = new StringBuilder();
        byte c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                break;
            }
            sb.append((char) c);
        }
        return sb.toString();
    }

    public String readLine(int size) {
        byte[] buf = new byte[size];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                break;
            }
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() {
        int n = 0;
        boolean neg = false;
        int c;
        while ((c = read()) <= ' ') ;
        neg = c == '-';
        if (neg) {
            c = read();
        }
        do {
            n = n * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (c == 13) {
            read();
        }
        return neg ? -n : n;
    }

    public long nextLong() {
        long n = 0;
        boolean neg = false;
        int c;
        while ((c = read()) <= ' ') ;
        neg = c == '-';
        if (neg) {
            c = read();
        }
        do {
            n = n * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (c == 13) {
            read();
        }
        return neg ? -n : n;
    }

    public double nextDouble() {
        double n = 0, div = 1;
        boolean neg = false;
        int c;
        while ((c = read()) <= ' ') ;
        neg = c == '-';
        if (neg) {
            c = read();
        }
        do {
            n = n * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                n += (c - '0') / (div *= 10);
            }
        }
        if (c == 13) {
            read();
        }
        return neg ? -n : n;
    }

    private void fillBuffer() {
        try {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte read() {
        if (bufferPointer == bytesRead) {
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }

    public void close() {
        try {
            if (din == null) {
                return;
            } else {
                din.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}