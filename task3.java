import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.util.Comparator.naturalOrder;

public class task3 {
    public static void main(String[] args){
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to \n" +
                "understand every single line of code."));
        System.out.println(replaceDouble("bookkeeper"));
        System.out.println(BlockFit(1, 8, 1, 1, 1));
        System.out.println(SumPow2Check(52));
        System.out.println(CountR(new int[]{1, -6, 9}));
        System.out.println(salesData(new String[][]{new String[] {"Fridge", "Shop2", "Shop3"},
                new String[] {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                new String[] {"Laptop", "Shop3", "Shop4"},
                new String[] {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}));
        System.out.println(valSplit("cat dog goose fish"));
        System.out.println(waveForm(new int[]{1,2,3,4,5}));
        System.out.println(commonVowel("WOW.,asd  aaaaaasdfaa 123qasd"));
        System.out.println(dataSc(new int[][]{new int[] {1,2,3,4,5},
                new int[] {6,7,8,29,10}, new int[] {5,5,5,5,35},
                new int[] {7,4,3,14,2}, new int[] {1,0,11,10,1}}));
    }

    public static String replaceVowels(String string){
        return string.replaceAll("[aeiouyAEIOUY]","*");
    }

    public static String replaceDouble(String string){

        int i = 0;
        StringBuilder sb = new StringBuilder(string.toLowerCase());
        while (i<sb.length()-1){
            if (sb.charAt(i) == sb.charAt(i+1)){
                sb = sb.replace(i,i+2,"Double"+sb.toString().toUpperCase().charAt(i));
                i = i+6;
            }
            i++;
        }
        return sb.toString();
    }

    public static boolean BlockFit(int a, int b, int c, int w, int h){
        int sq = w*h;
        return a * b <= sq || a * c <= sq || b * c <= sq;
    }

    public static boolean SumPow2Check(int a){
        String str = ""+a;
        int sum = 0;
        for (int i = 0; i <str.length();i++){
            int i1 = Integer.parseInt("" + str.charAt(i));
            sum += i1 * i1;
        }
        return a % 2 == sum % 2;
    }

    public static int CountR(int[] array){
        int a = array[0];
        int b = array[1];
        int c = array[2];
        int D = b*b - 4*a*c;
        if(D > 0){
            return 2;
        } else if (D == 0){
            return 1;

        }
        else{
            return 0;
        }

    }

    public static String salesData(String[][] matrix) {
        Set<String> set = new HashSet<String>();
        for (String[] strings : matrix) {
            if (strings.length == 5) {
                set.add(strings[0]);
            }
        }
        return set.toString();
    }

    public static boolean valSplit(String string){
        String[] arr = string.toLowerCase().replaceAll("\\p{Punct}", "").split(" ");
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i].charAt(arr[i].length()-1) != arr[i+1].charAt(0)){
                return false;
            }
        }
        return true;
    }

    public static boolean waveForm(int[] arr){
        int n;
        if (arr[0]-arr[1]>0){
            n = 0;
        }
        else{
            n = 1;
        }
        for (int i = 0; i < arr.length-1; i ++){

            if(Math.pow(-1,(double)i+n) != (double)((arr[i]-arr[i+1])/Math.abs(arr[i]-arr[i+1]))){
                return false;
            }
        }
        return true;
    }
    public static Integer getMaxValue(Integer... numbers) {
        return Arrays.stream(numbers)
                .filter(Objects::nonNull)
                .max(naturalOrder())
                .orElse(1);
    }
    public static String commonVowel(String str){
        str = str.toLowerCase().replaceAll("[^aeiouy]","");
        //char[] arr = str.toCharArray();
        int Astr = str.replaceAll("[^a]","").length();
        int Estr = str.replaceAll("[^e]","").length();
        int Istr = str.replaceAll("[^i]","").length();
        int Ostr = str.replaceAll("[^o]","").length();
        int Ustr = str.replaceAll("[^u]","").length();
        int Ystr = str.replaceAll("[^y]","").length();

        int max = getMaxValue(Astr,Estr,Istr,Ostr,Ustr,Ystr);

        if (Astr == max){
            return "a";
        } else if (Estr == max) {
            return "e";
        } else if (Istr == max) {
            return "i";
        } else if (Ostr == max) {
            return "o";
        } else if (Ustr == max) {
            return "u";
        } else {
            return "y";
        }
    }

    public static String dataSc(int[][] matrix){
        int n = matrix.length;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++){
            int sum = 0;
            for (int[] ints : matrix) {
                sum += ints[j];
            }
            sum -= matrix[j][j];
            int avg = (int)Math.round((double)sum/(double)(n-1));
            matrix[j][j] = avg;
            sb.append(Arrays.toString(matrix[j]));
            sb.append(",\n");
        }
        sb.replace(sb.length()-2,sb.length(), "");
        return sb.toString();
    }
}
