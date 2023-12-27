import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class randomtext {
    public static String random_text(int length) {
        String hangul = generateHangul(length);
        String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String combined = combineStrings(hangul, alphabets, length);

        List<Character> combinedChars = new ArrayList<>();
        for (char c : combined.toCharArray()) {
            combinedChars.add(c);
        }
        Collections.shuffle(combinedChars);

        StringBuilder result = new StringBuilder();
        for (char c : combinedChars.subList(0, length)) {
            result.append(c);
        }

        return result.toString();
    }

    public static String generateHangul(int length) {
        StringBuilder hangul = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int initialHangul = 44032; 
            int hangulCode = initialHangul + random.nextInt(11172);
            hangul.append((char) hangulCode);
        }

        return hangul.toString();
    }

    public static String combineStrings(String hangul, String alphabets, int length) {
        StringBuilder combined = new StringBuilder();

        for (int i = 0; i < length * 2; i++) {
            if (i % 2 == 0) {
                combined.append(hangul.charAt(i / 2));
            } else {
                Random random = new Random();
                combined.append(alphabets.charAt(random.nextInt(alphabets.length())));
            }
        }

        return combined.toString();
    }
    public static void main(String[] args){
        String wowww = random_text(10);
        System.out.println(wowww);
    }
}
