
public class Unbox {

    /**
     * Рекурсия для выражения с вложенными скобками
     */
    public static String recursFirst(String inputText) {
        if (!inputText.contains("[")) return inputText;

        return recursFirst(inputText.substring(inputText.lastIndexOf("[") + 1, searchBracket(inputText)));
    }

    public static int searchBracket(String inputText){
        char[] symbolArray = inputText.toCharArray();
        int startCount = inputText.lastIndexOf("[");
        for(int i = startCount; i<symbolArray.length-1; i++){
            if(symbolArray[i] == ']'){
                return i;
            }
        }
        return 0;
    }
    /**
     * Рекурсия для выражения без вложенных скобок
     */
    public static String recursSecond(String inputText) {
        if (!inputText.contains("[")) return inputText;

        return recursSecond(inputText.substring(inputText.indexOf("[") + 1, inputText.indexOf("]")));
    }

    /**
     * Есть ли вложенные скобки в выражении
     */
    public static boolean getDoubleBracket(String inputText) {
        char[] wordsArray = inputText.toCharArray();
        int count = 0;
        for (char c : wordsArray) {
            if (c == '[') {
                count++;
            } else if (c == ']') {
                count--;
            }
            if (count > 1) {
                break;
            }
        }
        return count > 1;
    }

    /**
     * Определение подходящей рекурсии под выражение
     */
    public static String getLogic(String inputText) {
        if (getDoubleBracket(inputText)) {
            return recursFirst(inputText);
        }
        return recursSecond(inputText);
    }

    /**
     * Получить количество повторений
     */
    public static int getCount(String inputText, String currentString) {
        int count = 0;
        if (inputText.length() > 0) {
            char countString = inputText.charAt(inputText.indexOf(currentString) - 1);
            if (Character.isDigit(countString)) {
                return Character.getNumericValue(countString);
            }
        }
        return count;
    }

    /**
     * Создание строки из внутреннего выражение
     */
    public static String addToBuilder(String current, int count) {
        StringBuilder temporaryBuilder = new StringBuilder();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                temporaryBuilder.append(current);
            }
            return temporaryBuilder.toString();
        } else return "";
    }

    /**
     * Распаковка строки
     */
    public static String unboxing(String inputText) {
        String updateString = inputText;

        while (updateString.contains("[")) {
            String current = getLogic(updateString);
            String currentWith = "[" + current + "]";
            int count = getCount(updateString, currentWith);

            String newCurrent = count + "\\[" + current + "\\]";
            String result = addToBuilder(current, count);
            updateString = updateString.replaceFirst(newCurrent, result);
        }
        return updateString;
    }
}
