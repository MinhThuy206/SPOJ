import java.util.Scanner;

public class ACMnew {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] array = new int[N];
            for (int j = 0; j < array.length; j++) {
                array[j] = sc.nextInt();
            }
            int M = sc.nextInt();

            System.out.println(WeightTeam(M, array));

        }
    }

    public static int WeightTeam(int maxWeight, int[] weight) {
        int sum = 0;
        for (int i = 0; i < weight.length - 2; i++) {
            for (int j = i + 1; j < weight.length - 1; j++) {
                for (int k = j + 1; k < weight.length; k++) {
                    if (sum < weight[i] + weight[j] + weight[k] && weight[i] + weight[j] + weight[k] <= maxWeight) {
                        sum = weight[i] + weight[j] + weight[k];
                    }
                }
            }
        }
        return sum;
    }
}
