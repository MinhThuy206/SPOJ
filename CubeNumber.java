import java.util.Scanner;

public class CubeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int max = 0;
            for (int j = 1; j <= Math.sqrt(N); j++) {
                if (j * j * j <= N) {
                    max = j;
                }
            }
            System.out.println(max);
        }
    }
}
