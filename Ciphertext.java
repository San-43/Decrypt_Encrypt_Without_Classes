package encryptdecrypt;


public class Ciphertext {
    static void ciphertext (String text) {
        char ch;
        int a = 012;

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
        double a = 4;
        double b = 2;
        System.out.println(a / b * 2);
    }
}