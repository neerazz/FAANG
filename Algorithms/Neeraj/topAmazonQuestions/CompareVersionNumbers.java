import java.util.*;

class CompareVersionNumbers{
  public static void main(String[] args) {
    System.out.println(compareVersion("1.0.1","1") + " should be [1]");
    System.out.println(compareVersion("0.1","1.1") + " should be [-1]");
    System.out.println(compareVersion("1.01","1.001") + " should be [0]");
  }
  public static int compareVersion(String version1, String version2) {
    String[] nums1 = version1.split("\\.");
    String[] nums2 = version2.split("\\.");
    int n1 = nums1.length, n2 = nums2.length;

    // compare versions
    int i1, i2;
    for (int i = 0; i < Math.max(n1, n2); ++i) {
      i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
      i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
      if (i1 != i2) {
        return i1 > i2 ? 1 : -1;
      }
    }
    // the versions are equal
    return 0;
  }
}
