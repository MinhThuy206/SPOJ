import java.util.Scanner;
public class FactorialPrime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int P = sc.nextInt();
            if(!(isFactorialPrime(P))){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
    public static boolean isFactorialPrime(int P){
        for(int i=0;i<P;i++){
            if ((P - factorial(i) == 1) || (P - factorial(i) == -1) || (P==2)){
                return true;
            }
        }
        return false;
    }
    public static int factorial(int n){
        int var=1;
        for(int i=1;i<=n;i++){
            var *=i;
        }
        return var;
    }

}
