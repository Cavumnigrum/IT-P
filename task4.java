import java.util.*;

public class task4 {
    public static void main(String[] args) {
        System.out.println(nonRep("abracadabra"));

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println(generateBrackets(4));

        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println(binarySystem(5));

        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("abcdefjqrstsuvwsxyz"));
        System.out.println(alphabeticRow("klmabzyxw"));

        System.out.println(countAndSortCharacters("aaabbcdd"));
        System.out.println(countAndSortCharacters("vvvvaajaaaaa"));

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(shortestWay(grid1));

        int[][] grid2 = {{2, 7, 3}, {1, 4, 8}, {4, 5, 9}};
        System.out.println(shortestWay(grid2));

        System.out.println(numericOrder(new StringBuilder("t3o the5m 1One all6 r4ule ri2ng")));
        System.out.println(numericOrder(new StringBuilder("re6sponsibility Wit1h gr5eat power3 4comes g2reat")));

        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    public static String nonRep(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        char[] without_first = Arrays.copyOfRange(chars, 1, chars.length);
        char first = chars[0];
        String new_s = "";
        for (int i = 0; i != without_first.length; i++) {
            if (without_first[i] == first) {

            } else {
                new_s += without_first[i];
            }
        }
        return first + nonRepeatable(new_s);
    }


    public static String nonRepeatable(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        char first = chars[0];
        String new_s = "";
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != first)
                new_s += chars[i];
        }
        return first + nonRepeatable(new_s);
    }


    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        generateBracketsHelper(n, n, "", result);
        return result;
    }

    private static void generateBracketsHelper(int left, int right, String current, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }
        if (left > 0) {
            generateBracketsHelper(left - 1, right, current + "(", result);
        }
        if (right > left) {
            generateBracketsHelper(left, right - 1, current + ")", result);
        }
    }

    public static StringBuilder binarySystem(int n){
        //StringBuilder s = new StringBuilder(Integer.toString((int) (Math.random() * 2)));
        List<StringBuilder> str = new ArrayList<>();
        StringBuilder s = new StringBuilder("0");
        int i = 0;
        while (s.length() <= n){
            if (s.charAt(i) == '0') s.append('1');
            else s.append('0');
            i++;
        }
        str.add(s);
        StringBuilder sw = new StringBuilder("1");
        int iw = 0;
        while (sw.length() <= n){
            if (sw.charAt(iw) == '0') sw.append('1');
            else sw.append('0');
            iw++;
        }
        str.add(sw);
        return new StringBuilder(str.toString());
    }
    public static String alphabeticRow(String input) {
        String longestRow = "";
        String currentRow = String.valueOf(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char prevChar = input.charAt(i - 1);

            if (currentChar - prevChar == 1 || prevChar - currentChar == 1) {
                currentRow += currentChar;
            } else {
                if (currentRow.length() > longestRow.length()) {
                    longestRow = currentRow;
                }
                currentRow = String.valueOf(currentChar);
            }
        }

        if (currentRow.length() > longestRow.length()) {
            longestRow = currentRow;
        }

        return longestRow;
    }


    public static StringBuilder countAndSortCharacters(String str) {
        ArrayList<String> array = new ArrayList<>();
        StringBuilder solution = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            char current = str.charAt(i);
            char next = str.charAt(i + 1);
            if (current == next) {
                counter += 1;
                if (i == str.length() - 2) {
                    array.add(counter + String.valueOf(current));
                }
            } else {
                array.add(counter + String.valueOf(current));
                counter = 1;
            }
        }
        Collections.sort(array);
        for (int i = 0; i < array.size(); i++) {
            StringBuilder temp = new StringBuilder(array.get(i));
            temp.reverse();
            solution.append(temp);
        }
        return solution;
    }

    private static final Map<String, Integer> numberMap = new HashMap<>();

    static {
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
        numberMap.put("ten", 10);
        numberMap.put("eleven", 11);
        numberMap.put("twelve", 12);
        numberMap.put("thirteen", 13);
        numberMap.put("fourteen", 14);
        numberMap.put("fifteen", 15);
        numberMap.put("sixteen", 16);
        numberMap.put("seventeen", 17);
        numberMap.put("eighteen", 18);
        numberMap.put("nineteen", 19);
        numberMap.put("twenty", 20);
        numberMap.put("thirty", 30);
        numberMap.put("forty", 40);
        numberMap.put("fifty", 50);
        numberMap.put("sixty", 60);
        numberMap.put("seventy", 70);
        numberMap.put("eighty", 80);
        numberMap.put("ninety", 90);
        numberMap.put("hundred", 100);
        numberMap.put("thousand", 1000);
    }

    public static int convertToNum(String input) {
        String[] words = input.split(" ");
        int result = 0;
        int currentNumber = 0;

        for (String word : words) {
            if (numberMap.containsKey(word)) {
                int number = numberMap.get(word);
                if (number == 100) {
                    currentNumber *= number;
                } else if (number == 1000 || number == 1000000) {
                    result += currentNumber * number;
                    currentNumber = 0;
                } else {
                    currentNumber += number;
                }
            }
        }

        return result + currentNumber;
    }
    private static String uniqueSubstring(String str) {
        char[] chars = str.toCharArray();
        String res = "";
        String s = "";

        for (int i = 0; i != chars.length-1; i++) {
            if (s.length() == 0){
                s += chars[i];
            }
            if (!s.contains(String.valueOf(chars[i+1]))) {
                s += chars[i+1];

            } else if (res.length() < s.length()) {
                res = s;
                s = "";
            } else if (res.length() == s.length()) {
                s = "";
            }
        }
        if (s.length()> res.length()) {
            return s;
        }
        return res;
    }


    public static StringBuilder numericOrder(StringBuilder input) {
        String[] words = input.toString().split(" ");
        String[] outputWords = new String[words.length];

        for (String word : words) {
            int index = Integer.parseInt(word.replaceAll("[^0-9]", "")) - 1;
            outputWords[index] = word.replaceAll("[0-9]", "");
        }

        return new StringBuilder(String.join(" ", outputWords));
    }
    public static int shortestWay(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int switchNums(int num1, int num2) {
        // Преобразовываем числа в массивы цифр
        int[] digits1 = getDigits(num1);
        int[] digits2 = getDigits(num2);

        // Создаем копию массива digits1 для поиска максимальной неповторяющейся цифры
        int[] availableDigits = Arrays.copyOf(digits1, digits1.length);

        // Проходим по цифрам второго числа
        for (int i = 0; i < digits2.length; i++) {
            int max = -1;
            int maxIndex = -1;

            // Ищем максимальную неповторяющуюся цифру из доступных
            for (int j = 0; j < availableDigits.length; j++) {
                if (availableDigits[j] >= max) {
                    max = availableDigits[j];
                    maxIndex = j;
                }
            }

            // Если нашли подходящую цифру, заменяем текущую цифру во втором числе
            if (max >= digits2[i]) {
                digits2[i] = max;
                availableDigits[maxIndex] = -1; // Помечаем использованную цифру
            }
        }

        // Собираем цифры обратно в число
        int result = 0;
        for (int j : digits2) {
            result = result * 10 + j;
        }

        return result;
    }


    public static int[] getDigits(int num) {
        String numStr = String.valueOf(num);
        int[] digits = new int[numStr.length()];

        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }

        return digits;
    }

}
