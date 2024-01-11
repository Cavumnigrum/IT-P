public class Main {
    public static void main(String[] args) {

        System.out.println(convert(5));
        System.out.println(fit(41,3));
        System.out.println(containers(5,0,2));
        System.out.println(triangles(5,4,5));
        System.out.println(ternaryEval(1,11));
        System.out.println(FFS(22,1.4,2.0));
        System.out.println(fac(5));
        System.out.println(gcd(259,28));
        System.out.println(tickets(70,1500));
        System.out.println(tables(64,20));
    }
    public static double convert(int G){
        double res = G * 3.785;
        return res;
    }

    public static int fit(int C, int T){
        int res = C * T;
        return res;
    }

    public static int containers(int Box, int Bag, int Barrel){
        int res = Box*20 + Bag*50 + Barrel*100;
        return res;
    }

    public static String triangles(int A, int B, int C){
        if ((A+B > C) && (A+C > B) && (B+C > A)){
            if (A == B && A == C){
                String res = "равносторонний";
                return res;
            }
            else if (A == B || A == C || B == C){
                String res = "равнобедренный";
                return res;
            }
            else{
                String res = "разносторонний";
                return res;
            }
        }
        else{
            String res = "не является треугольником";
            return res;
        }
    }

    public static int ternaryEval(int A, int B){
        int res = A > B ? A : B;
        return res;
    }
    public static int fac(int x){
        if (x == 0 || x == 1){
            return 1;
        }
        else if (x>1) {
            return x * fac(x - 1);
        }
        else{
            return -1;
        }
    }

    public static int gcd(int a, int b){
        int c;
        while (b != 0){
            c = a;
            a = b;
            b = c % a;
        }
        return a;
    }
    public static int tickets(int count, int cost){
        int new_Cost = (int)(cost*0.72);
        return count*new_Cost;
    }

    public static int tables(int students, int table){
        int res = table * 2 >= students ? 0 : (students - (table*2))%2 + (students - (table*2))/2;

        return res;
    }

    public static int FFS(int n, double w, double h){
        return (int)(n/(w*h*2));
    }




}