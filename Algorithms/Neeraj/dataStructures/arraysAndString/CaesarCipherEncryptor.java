class CaesarCipherEncryptor {
    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 2));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        char[] chars = new char[]
                {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            int index = c - 'a' + key;
            if (index > 25) {
                index %= 26;
            }
            sb.append(chars[index]);
        }
        return sb.toString();
    }
}
