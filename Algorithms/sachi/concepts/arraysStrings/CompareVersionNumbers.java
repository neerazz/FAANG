public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int p1 = 0, p2 = 0;

        while (p1 < v1.length && p2 < v2.length) {
            int n1 = Integer.parseInt(v1[p1++]);
            int n2 = Integer.parseInt(v2[p2++]);
            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            }
        }

        while (p1 < v1.length) {
            int i = Integer.parseInt(v1[p1++]);
            if (i > 0) return 1;
        }

        while (p2 < v2.length) {
            int i = Integer.parseInt(v2[p2++]);
            if (i > 0) return -1;
        }
        return 0;
    }

}
