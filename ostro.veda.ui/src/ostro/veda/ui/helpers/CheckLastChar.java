package ostro.veda.ui.helpers;

public class CheckLastChar {

    public static boolean hasChar(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        char[] characters = input.toCharArray();
        char lastChar = characters[characters.length - 1];

        for (char c : "-+/*".toCharArray()) {
            if (lastChar == c) {
                return true;
            }
        }
        return false;
    }
}
