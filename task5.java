import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class task5 {
    public static void main(String[] args){
        System.out.println(sameLetterPattern(new StringBuilder("abcd"), new StringBuilder("ABCD")));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println(digitsCount(1289396387328L));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(sumsUp(new int[]{1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}));
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));
        System.out.println(caesarCipher("encode", "almost last task!", 4));
        System.out.println(setSetup(5, 3));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "New Delhi"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println(isNew(321));

    }

    private static boolean sameLetterPattern(StringBuilder str1, StringBuilder str2){
        if (str1.length() != str2.length()) return false;
        Map<Character, Character> letterMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++){
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (letterMap.containsKey(char1)){
                if (letterMap.get(char1) != char2) return false;
                else letterMap.put(char1, char2);
            }
        }
        return true;
    }

    private static String spiderVsFly(String spider, String fly) {
        final double cnst = 0.78;

        Map<Character, Character[]> idxMap = new HashMap<>();
        idxMap.put('A',new Character[]{'H', 'B'});
        idxMap.put('B',new Character[]{'A', 'C'});
        idxMap.put('C',new Character[]{'B', 'D'});
        idxMap.put('D',new Character[]{'C', 'E'});
        idxMap.put('E',new Character[]{'D', 'F'});
        idxMap.put('F',new Character[]{'E', 'G'});
        idxMap.put('G',new Character[]{'F', 'H'});
        idxMap.put('H',new Character[]{'G', 'A'});

        double sum = 0;
        StringBuilder str = new StringBuilder(spider + " ");
        int spI = Integer.parseInt(spider.replaceAll("[^0-9]", ""));
        char spP = (spider.replaceAll("[0-9]", "")).charAt(0);
        int flI = Integer.parseInt(fly.replaceAll("[^0-9]", ""));
        char flP = (fly.replaceAll("[0-9]", "").charAt(0));

        Set<Character> setSp = new HashSet<>(Arrays.asList(idxMap.get(spP)));
        Set<Character> setFl = new HashSet<>(Arrays.asList(idxMap.get(flP)));

        setSp.retainAll(setFl);

        if (contains(idxMap.get(spP), flP) | !setSp.isEmpty()){
            while (spI != flI){
                if (spI > flI) spI -= 1;
                else spI += 1;
                spider = spP + String.valueOf(spI);
                str.append(spider + " ");
                sum += 1;
            }
            if (!setSp.isEmpty()){
                sum += cnst * spI;
                spP = setSp.iterator().next();
                spider = spP + String.valueOf(spI);
                str.append(spider + " ");
            }
            sum += cnst * spI;
            spP = flP;
            spider = spP + String.valueOf(spI);
            System.out.print(sum+": ");
            str.append(spider + " ");
            return str.toString().strip().replaceAll(" ", "-");
        }
        else {
            while (spI != 1){
                spI -= 1;
                spider = spP + String.valueOf(spI);
                str.append(spider + " ");
                sum += 1;
            }
            spI = 0;
            spP = 'A';
            sum += 1;
            spider = spP + String.valueOf(spI);
            str.append(spider + " ");
            while (!spider.equals(fly)){
                spI += 1;
                spP = flP;
                spider = spP + String.valueOf(spI);
                sum += 1;
                str.append(spider   + " ");
            }
            System.out.print(sum+": ");
            return str.toString().strip().replaceAll(" ", "-");
        }

    }
    private static int digitsCount(long value){
        if (value == 0){
            return 1;
        }
        else{
            return countDigits(value / 10);
        }
    }

    private static int countDigits(long value){
        if (value == 0) return 1;
        else return 1 + countDigits(value / 10);
    }

    public static<T> boolean contains(T[] values, T target) {
        return Arrays.asList(values).stream()
                .filter(x -> x.equals(target))
                .count() > 0;
    }

    public static int totalPoints(String[] scramble_worlds, String origin_word) {
        int c = 0;
        for (String word : scramble_worlds) {
            boolean t_f = true;
            String origin_copy = origin_word;
            for (int i = 0; i < word.length(); i++) {

                if (origin_copy.contains(String.valueOf(word.charAt(i)))) {
                    origin_copy = origin_copy.replace(word.charAt(i), ' ');
                } else {

                    t_f = false;
                    break;
                }
            }
            if (t_f) {

                switch (word.length()) {
                    case 3:
                        c += 1;
                        break;
                    case 4:
                        c += 2;
                        break;
                    case 5:
                        c += 3;
                        break;
                    case 6:
                        c += 54;
                }

            }
        }
        return c;
    }

    private static List<List<Integer>> sumsUp(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 8) {
                    List<Integer> pair = Arrays.asList(arr[i], arr[j]);
                    result.add(pair);
                }
            }
        }

        return result;
    }

    private static String takeDownAverage(String[] grades) {
        int sum = 0;
        for (String i:grades){
            sum += Integer.parseInt(i.replaceAll("%",""));
        }
        int oldAvg = (int)(sum/grades.length);
        int newLen = grades.length + 1;
        int newAvg = oldAvg - 5;
        int newSum = newAvg * newLen;
        return newSum-sum+"%";
    }

    private static String caesarCipher(String operation, String message, int shift) {
        StringBuilder result = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                int base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shiftedChar = (char) ((ch - base + (operation.equals("encode") ? shift : -shift) + 26) % 26 + base);
                result.append(shiftedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private static int setSetup(int n, int k) {
        return factorial(n) / factorial(n - k);
    }

    private static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static String timeDifference(String cityA, String timestamp, String cityB){
        HashMap<String, String> greenwich = new HashMap<>();
        greenwich.put("Los Angeles", "America/Los_Angeles");
        greenwich.put("New York", "America/New_York");
        greenwich.put("Caracas", "America/Caracas");
        greenwich.put("Buenos Aires", "America/Argentina/Buenos_Aires");
        greenwich.put("London", "Europe/London");
        greenwich.put("Rome", "Europe/Rome");
        greenwich.put("Moscow", "Europe/Moscow");
        greenwich.put("Tehran", "Asia/Tehran");
        greenwich.put("New Delhi", "Asia/Kolkata");
        greenwich.put("Beijing", "Asia/Shanghai");
        greenwich.put("Canberra", "Australia/Canberra");

        DateTimeFormatter form = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.UK);

        ZonedDateTime time = ZonedDateTime.parse(timestamp, form.withZone(ZoneId.of(cityA, greenwich)));

        return time.withZoneSameInstant(ZoneId.of(cityB, greenwich)).format(DateTimeFormatter.ofPattern("yyyy-M-d HH:mm"));

    }

    private static boolean isNew(int num) {
        String original = String.valueOf(num);
        char[] originalChars = original.toCharArray();
        Arrays.sort(originalChars);

        for (int i = 1; i < num; i++) {
            String current = String.valueOf(i);
            char[] currentChars = current.toCharArray();
            Arrays.sort(currentChars);

            if (Arrays.equals(originalChars, currentChars)) {
                return false;
            }
        }

        return true;
    }


}
