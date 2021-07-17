import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Jun 24, 2021
 * Ref: https://leetcode.com/discuss/interview-question/398023/Microsoft-Online-Assessment-Questions/983312
 * Question: Given an ipv4 address (string) and a cidr value (string) return if ip4v is a valid address in cidr range.
 * Source: https://wintelguy.com/subnetcalc.pl, https://github.com/edazdarevic/CIDRUtils/blob/master/CIDRUtils.java
 */

public class IP4ValidationWithCIDR {

    public static void main(String[] args) {
        System.out.println(isValidIPV4("10.1.1.5/24", "10.1.1.1"));
        System.out.println(isValidIPV4("10.1.1.5/24", "10.1.1.4"));
        System.out.println(isValidIPV4("10.1.1.5/24", "10.1.1.89"));
        System.out.println(isValidIPV4("10.1.1.5/24", "10.1.1.254"));
        System.out.println(isValidIPV4("10.1.1.5/24", "10.1.1.100"));
    }

    private boolean test1(int[] nums) {
        System.out.println("Before = " + Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int tem = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tem;
            }
        }
        System.out.println("After = " + Arrays.toString(nums));
        return true;
    }

    public static boolean isValidIPV4(String cidr, String ipAddress) {
        InetAddress[] ranges = null;
        try {
            ranges = getIPRange(cidr);
            return ipInRange(ranges, ipAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean ipInRange(InetAddress[] ranges, String ipAddress) throws UnknownHostException {
        BigInteger start = new BigInteger(1, ranges[0].getAddress());
        BigInteger end = new BigInteger(1, ranges[1].getAddress());
        InetAddress address = InetAddress.getByName(ipAddress);
        BigInteger target = new BigInteger(1, address.getAddress());
        return start.compareTo(target) <= 0 && target.compareTo(end) <= 0;
    }

    private static InetAddress[] getIPRange(String cidr) throws UnknownHostException {
        int index = cidr.indexOf("/");
        if (index == -1) throw new IllegalArgumentException("Not an valid CIDR format.");
        String address = cidr.substring(0, index);
        String network = cidr.substring(index + 1);
        InetAddress inetAddress = InetAddress.getByName(address);
        int prefixLength = Integer.parseInt(network);
        if (prefixLength > 32) {
            throw new IllegalArgumentException("Not an valid CIDR format, network range should be between 0 to 32.");
        }
        ByteBuffer maskBuffer;
        int targetSize;
        if (inetAddress.getAddress().length == 4) {
            maskBuffer = ByteBuffer.allocate(4).putInt(-1);
            targetSize = 4;
        } else {
            maskBuffer = ByteBuffer.allocate(16).putLong(-1L).putLong(-1L);
            targetSize = 16;
        }

//        Shift towards the right, if the buffer has negative value.
        BigInteger mask = new BigInteger(1, maskBuffer.array()).not().shiftRight(prefixLength);

        ByteBuffer buffer = ByteBuffer.wrap(inetAddress.getAddress());
        BigInteger ipVal = new BigInteger(1, buffer.array());

        InetAddress startAddress = getAddress(ipVal, mask, targetSize);
        InetAddress endAddress = getAddress(ipVal.add(mask.not()), mask, targetSize);
        return new InetAddress[]{startAddress, endAddress};
    }

    private static InetAddress getAddress(BigInteger ipVal, BigInteger mask, int targetSize) throws UnknownHostException {
        BigInteger newIPValue = ipVal.and(mask);
        byte[] bytesValue = toBytes(newIPValue.toByteArray(), targetSize);
        return InetAddress.getByAddress(bytesValue);
    }

    private static byte[] toBytes(byte[] array, int targetSize) {
        int counter = 0;
        List<Byte> newArr = new ArrayList<Byte>();
        while (counter < targetSize && (array.length - 1 - counter >= 0)) {
            newArr.add(0, array[array.length - 1 - counter]);
            counter++;
        }

        int size = newArr.size();
        for (int i = 0; i < (targetSize - size); i++) {

            newArr.add(0, (byte) 0);
        }

        byte[] ret = new byte[newArr.size()];
        for (int i = 0; i < newArr.size(); i++) {
            ret[i] = newArr.get(i);
        }
        return ret;
    }
}
