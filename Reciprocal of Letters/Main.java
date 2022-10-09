package encryptdecrypt;


public class Main {
    static void ciphertext (String text) {
        char ch;

        for (int i = 0; i <  text.length(); i++) {
            ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    ch = (char)(122 - (int)(ch) + 97);
                } else {
                    ch = (char)(90 - (int)(ch) + 65);
                }
            }
            System.out.print(ch);
        }
    }

    public static void main(String[] args) {
        String s = "we found a treasure!";
        ciphertext(s);
        System.out.print(4 / 4 * 2);
    }
}