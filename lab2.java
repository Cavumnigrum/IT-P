import java.util.*;

public class lab2 {
    public static void main(String[] args) {
        System.out.println(dupChars("qwee"));
        System.out.println(getInit("Rayan Gosling"));
        System.out.println(differenceEvenOdd(new int[]{44,32,86,19}));
        System.out.println(includeAVG(new int[]{1,2,3}));
        System.out.println(indexMult(new int[]{3,3,-2,408,3,31 }));
        System.out.println(reverseString("Hello, World!"));
        System.out.println(Tribonacci(11));
        System.out.println(psHash(4));
        System.out.println(botHelp("please HELps pme"));
        System.out.println(isAnagram("Hello","World"));
    }
    public static Set convertToSet(String string) {
        Set resultSet = new HashSet();

        for (int i = 0; i < string.length(); i++) {
            resultSet.add(string.charAt(i));
        }

        return resultSet;
    }
    public static boolean dupChars(String T){
        int len = T.length();
        int NL = convertToSet(T.toLowerCase()).size();
        return len != NL;
    }

    public static String getInit(String T){
        String[] Tsplited = T.split(" ");
        return ""+Tsplited[0].charAt(0)+Tsplited[1].charAt(0);
    }

    public static int differenceEvenOdd(int[] array){
        int evenSum = 0;
        int oddSum = 0;
        for (int i=0; i < array.length; i++){
            if (array[i]%2 == 0){
                evenSum+=array[i];
            }
            else{
                oddSum+=array[i];
            }
        }
        return Math.abs(evenSum-oddSum);
    }

    public static boolean includeAVG(int[] array){
        int AVG = (int)Arrays.stream(array).average().getAsDouble();
//        System.out.println(Arrays.asList(array).contains(AVG));
        for (int i = 0; i < array.length; i++){
            if (AVG == array[i]) {
                return true;
            }
        }
        return false;
    }

    public static String indexMult(int[] array){
        for (int i = 0; i < array.length; i++) {
                array[i] = array[i]*i;
            }

        return Arrays.toString(array);
    }

    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        String res = sb.reverse().toString();
        return res;
    }

    public static int Tribonacci(int x){
        if (x==1 || x == 2 ){
            return 0;
        } else if (x == 3) {
            return 1;
        }
        else if(x>0){
            return Tribonacci(x-1) + Tribonacci(x-2) + Tribonacci(x-3);
        }
        return 0;
    }

    public static String psHash(int x){
        String[] array = new String[]{"a","b","c","d","e","f","0","1","2","3","4","5","6","7","8","9"};
        String S= "\"";
        for (int i=0;i<x;i++){
            int rnd = new Random().nextInt(array.length);
            S += array[rnd];
        }
        S+="\"";
        return S;
    }

    public static String botHelp(String string){
        String[] array = string.toLowerCase().split(" ");
        if (Arrays.asList(array).contains("help")){
            return "Calling for a staff member";
        }
        else{
            return "Keep waiting";
        }
    }

    public static boolean isAnagram(String first, String second){
        first = first.toLowerCase().replaceAll("\\s+", "").replaceAll("\\p{Punct}", "");
        second = second.toLowerCase().replaceAll("\\s+", "").replaceAll("\\p{Punct}", "");
        char[] fCharArray = first.toCharArray();
        char[] sCharArray = second.toCharArray();
        Arrays.sort(fCharArray);
        Arrays.sort(sCharArray);
        return Arrays.equals(fCharArray,sCharArray);
    }
}
