import java.util.*;

public class task6 {
    public static void main(String[] args){
        System.out.println("#1");
        System.out.println(hiddenAnagram(new String[]{"D  e b90it->?$ (c)a r...d,,#~", "bad credit"}));

        System.out.println("#2");
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15) ));

        System.out.println("#3");
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("iloveher", "612345") );

        System.out.println("#4");
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1,  2, -1,  4,  5,  6,  10, 7}, 20)));

        System.out.println("#5");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(40320)));

        System.out.println("#6");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)") );
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println("#7");
        System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string("FORALOOP"));
        System.out.println(pilish_string("CANIMAKEAGUESSNOW"));

        System.out.println("#8");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));

        System.out.println("#9");
        System.out.println(isValid("aabbc"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println("#10");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
        System.out.println(findLCS("HABRAHABR", "HARBOUR"));


    }

    public static String hiddenAnagram(String[] args){
        String original = args[0].toLowerCase().replaceAll("\\W*\\d*", "");
        String toFind = args[1].toLowerCase().replaceAll("\\W*", "");
        char[] parseStr = original.toCharArray();
        char[] parseFind = toFind.toCharArray();
        Arrays.sort(parseFind);
        if (parseStr.length != parseFind.length) {
            for (int i = 0; i < (parseStr.length - parseFind.length); i++) {
                char[] sicedArr = Arrays.copyOfRange(parseStr, i, i + parseFind.length);
                char[] copyArr = Arrays.copyOf(sicedArr, sicedArr.length);
                Arrays.sort(sicedArr);
                if (Arrays.equals(sicedArr, parseFind)) {
                    return String.valueOf(copyArr);
                }
            }
        }
        else {
            char[] copyArr = Arrays.copyOf(parseStr, parseStr.length);
            Arrays.sort(parseStr);
            if (Arrays.equals(parseStr, parseFind)) {
                return String.valueOf(copyArr);
            }
        }
        return "notfound";
    }


    public static String[] collect(String word, int n) {
        if (word.length() < n) {
            return new String[0];
        }

        String[] result = new String[word.length()/n];
        collectRecursive(word, n, result, 0, 0);
        Arrays.sort(result);
        return result;
    }

    private static void collectRecursive(String word, int n, String[] result, int index, int start) {
        if (start + n <= word.length()) {
            result[index] = word.substring(start, start + n);
            collectRecursive(word, n, result, index + 1, start + n);
        }
    }

    public static String nicoCipher(String message, String key){
        char[] messageCharArr = message.toCharArray();
        char[] keyCharArr = key.toCharArray();
        char[] copyKeyCharArr = Arrays.copyOf(keyCharArr, keyCharArr.length);
        int[] someArr = new int[keyCharArr.length];
        int nnI = Math.ceilDiv(messageCharArr.length, keyCharArr.length);
        StringBuilder result = new StringBuilder();
        StringBuilder[] str = new StringBuilder[nnI];
        Arrays.sort(copyKeyCharArr);

        for (int i = 0; i < keyCharArr.length; i ++){
            someArr[i] = findIdx(copyKeyCharArr, keyCharArr[i]);
        }
        for (int i = 0; i < keyCharArr.length * nnI; i++){
            int newI = i/keyCharArr.length;
            int newJ = i % keyCharArr.length;
            if (newJ == 0) {
                char[] charArray = new char[keyCharArr.length];
                Arrays.fill(charArray,' ');
                str[newI] = new StringBuilder(new String(charArray));
            }
            try {
                str[newI].replace(someArr[newJ], someArr[newJ] + 1, String.valueOf(messageCharArr[i]));
            }
            catch (Exception e){
                break;
            }
        }
        for(StringBuilder i: str){
            result.append(i);
        }
        return result.toString();
    }
    private static int findIdx(char[] incMass, char NF){
        for (int i = 0; i < incMass.length; i++){
            if (NF == incMass[i]){
                return i;
            }
        }
        return -1;
    }

    public static int[] twoProduct(int[] arr, int n){
        int[] resArr = new int[2];
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < i; j ++){
                if (j*i == n){
                     resArr[0] = j;
                     resArr[1] = i;
                     return resArr;
                }
            }
        }
        return new int[0];
    }

    public static int[] isExact(int n) {
        return isExactHelper(n, 1, 1);
    }

    private static int[] isExactHelper(int n, int current, int k) {
        if (current == n) {
            return new int[]{current, k};
        } else if (current > n) {
            return new int[]{};
        } else {
            return isExactHelper(n, current * (k + 1), k + 1);
        }
    }

    private static String fractions(String num){
        String[] splitted = num.split("\\.|,");
        int k = splitted[1].split("\\(")[1].length()-1;
        int m = splitted[1].split("\\(")[0].length();
        int a = Integer.parseInt(splitted[1].replaceAll("\\D", ""));
        int b = 0;
        try {
            b = Integer.parseInt(splitted[1].split("\\(")[0]);
        }
        catch (Exception e){}
        int y = Integer.parseInt(splitted[0]);
        char[] kpart = new char[k];
        char[] mpart = new char[m];
        StringBuilder str = new StringBuilder();

        Arrays.fill(kpart,'9');
        Arrays.fill(mpart,'0');

        str.append(String.valueOf(kpart)).append(String.valueOf(mpart));
        int denominator = Integer.parseInt(str.toString());
        int numerator = y*denominator+(a-b);
        int g = gcd(numerator,denominator);
        return numerator/g+"/"+denominator/g;
    }
    private static int gcd(int a, int b){
        int c;
        while (b != 0){
            c = a;
            a = b;
            b = c % a;
        }
        return a;
    }

    public static String pilish_string(String input){
        final char[] pi = "314159265358979".toCharArray();
        StringBuilder str = new StringBuilder();
        if(input.length()>=77){
            input = input.substring(0,77);
            int j = 0;
            for (char i: pi){
                str.append(input, j, j+Integer.parseInt(String.valueOf(i))).append(" ");
                j+=Integer.parseInt(String.valueOf(i));
            }
            return str.toString();
        }
        else if(input.isEmpty()){
            return "";
        }
        else{
            int j = 3;
            int i = 0;
            while (input.length()>=j){
                try {
                    String word = input.substring(0,j);
                    input = input.substring(j);
                    str.append(word).append(" ");
                    i++;
                    j = Integer.parseInt(String.valueOf(pi[i]));
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                    break;
                }
            }
            if (!input.isEmpty()){
                char[] man = Arrays.copyOf(input.toCharArray(), j);
                Arrays.fill(man, input.length()-1,j,input.charAt(input.length()-1));
                str.append(String.valueOf(man));
            }
            return str.toString();
        }
    }

    public static double generateNonconsecutive(String expression) {
        try {
            Stack<Double> values = new Stack<>();
            Stack<Character> operators = new Stack<>();

            int i = 0;
            while (i < expression.length()) {
                char c = expression.charAt(i);
                if (Character.isDigit(c) || (c == '-'&& i+1!=expression.length()&& expression.charAt(i+1)!=' ')) {
                    StringBuilder sb = new StringBuilder();
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.' || expression.charAt(i) == '-')) {
                        sb.append(expression.charAt(i++));
                    }
                    values.push(Double.parseDouble(sb.toString()));
                } else if (c == '(') {
                    operators.push(c);
                    i++;
                } else if (c == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.pop();
                    i++;
                } else if (isOperator(c)) {
                    while (!operators.isEmpty() && hasPrecedence(c, operators.peek()) && operators.peek()!='(') {
                        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.push(c);
                    i++;
                } else if (!Character.isWhitespace(c)) {
                    throw new IllegalArgumentException("Invalid character in expression");
                } else {
                    i++;
                }
            }

            while (!operators.isEmpty()) {
                values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
            }

            return values.pop();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return Double.NaN;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        return (op2 != '+' && op2 != '-') || (op1 != '*' && op1 != '/');
    }

    private static double applyOperator(char operator, double b, double a) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    public static String isValid(String input){
        List<Integer> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        char[] man = input.toCharArray();
        for (char i: man){
            set.add(i);
        }
        for (char i: set){
            list.add(count(input,i));
        }
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        if(Objects.equals(max, min) | (Objects.equals(max-1,min) && Arrays.stream(list.toArray()).filter(number -> number == max).count()<2
                | (Objects.equals(max-1,min) && Arrays.stream(list.toArray()).filter(number -> number == min).count()<2))){
            return "YES";
        }
        return "NO";
    }

    private static Integer count(String input, char target){
        return (int)input.chars().filter(ch -> ch == target).count();
    }

    public static String findLCS(String str1, String str2){
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++){
            for(int j = 0 ; j <= n; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else{
                    dp [i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int idx = dp[m][n];
        //System.out.println(Arrays.deepToString(dp));
        char[] lcs = new char[idx];

        int i = m, j = n;
        while (i > 0 && j > 0){
            if (str1.charAt(i-1) == str2.charAt(j - 1)){
                lcs[--idx] = str1.charAt(i - 1);
                i--;
                j--;
            } else if(dp[i - 1][j] > dp[i][j - 1]){
                i--;
            } else{
                j--;
            }
        }
        return new String(lcs);
    }

}
