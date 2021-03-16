
public class Valid {
    public static boolean getValid(String inputText) {
        if (inputText.matches("^[a-zA-Z0-9\\[\\]]+$")) {
            return getDigitAndLetters(inputText) && getDoubleDigit(inputText) && getCountBrackets(inputText) && getCorrectBrackets(inputText)
                    && getDoubleBrackets(inputText);
        }
        return false;
    }

    /**
     * Равно ли количество правых и левых скобок
     */
    public static boolean getCountBrackets(String inputText) {
        char[] wordsArray = inputText.toCharArray();
        int right = 0;
        int left = 0;

        for (char c : wordsArray) {
            if (c == '[') {
                right++;
            } else if (c == ']') {
                left++;
            }
        }
        return right == left;
    }

    /**
     * Проверка на две подряд цифры
     */
    public static boolean getDoubleDigit(String inputText) {
        char[] wordsArray = inputText.toCharArray();
        for (int i = 0; i < wordsArray.length - 1; i++) {
            if (Character.isDigit(wordsArray[i]) && Character.isDigit(wordsArray[i + 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Содержит ли отформатированная строка только цифры и латиницу
     */
    public static boolean getDigitAndLetters(String inputText) {
        String checkString = inputText.replaceAll("\\[", "");
        checkString = checkString.replaceAll("\\]", "");
        return checkString.matches("^[a-zA-Z0-9]+$");
    }

    /**
     * Проверка на корректные растановку цифра + скобка
     */
    public static boolean getCorrectBrackets(String inputText) {
        char[] wordsArray = inputText.toCharArray();
        boolean result = false;
        for (int i = 0; i < wordsArray.length - 1; i++) {
            if (Character.isDigit(wordsArray[i])) {
                char elementCheck = wordsArray[i + 1];
                if (elementCheck == '[' || elementCheck == ']') {
                    result = true;
                } else return false;
            }
        }
        return result;
    }

    /**
     * Проверка на двойные скобки
     */
    public static boolean getDoubleBrackets(String inputText) {
        char[] wordsArray = inputText.toCharArray();
        for (int i = 0; i < wordsArray.length - 1; i++) {
            if (wordsArray[i] == '[' || wordsArray[i] == ']') {
                if (wordsArray[i + 1] == '[' || wordsArray[i + 1] == ']') {
                    return false;
                }
            }
        }
        return true;
    }
}
