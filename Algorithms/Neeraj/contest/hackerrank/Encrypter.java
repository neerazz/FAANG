
public class Encrypter {

    public static void main(String[] args) {
        System.out.println(Encrypter.getEncryptedName("Kate Winslet"));
    }

    public static String getEncryptedName(String name) {
        Validator validator = new Validator();
        if (validator.validate(name)) {
//            Reverse the Given String
            String reverseName = reverseName(name);
            return convertCases(reverseName);
        } else {
            throw new IllegalArgumentException("Try again with valid name");
        }
    }

    private static String convertCases(String reverseName) {
        char[] chars = reverseName.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (Character.isLowerCase(current)) {
                stringBuffer.append(Character.toUpperCase(current));
            } else {
                stringBuffer.append(Character.toLowerCase(current));
            }
        }
        return stringBuffer.toString();
    }

    private static String reverseName(String name) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = name.length() - 1; i >= 0; i--) {
            stringBuffer.append(name.charAt(i));
        }
        return stringBuffer.toString();
    }
}

class Validator {
    public boolean validate(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);

            if (ch != ' ' && !(Character.isLowerCase(ch) || Character.isUpperCase(ch))) {
                return false;
            }
        }
        return true;
    }
}