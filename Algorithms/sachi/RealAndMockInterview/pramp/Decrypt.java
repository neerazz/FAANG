public class Decrypt {

    static String decrypt(String word) {

        if (word == null || word.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int f = word.charAt(0) - 1;
        sb.append((char) f);
        int sum = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char curr = word.charAt(i);
            int val = curr - sum;
            while (val < 97) {
                val = val + 26;
            }
            sb.append((char) val);
            sum += val;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decrypt("dnotq"));
    }

}
