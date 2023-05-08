import java.util.Scanner;
import java.util.Stack;

public class STPAR {
    private static int[] result = new int[1500];
    private static boolean check = true;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int N;
        int[] order;
        while (true) {
            N = sc.nextInt();
            order = new int[N];
            if (N == 0) break;

            for (int i = 0; i < N; i++) {
                order[i] = sc.nextInt();
            }

            int start = 0;
            for (int i = 0; i < N - 1; i++) {
                if (order[i] > order[i + 1]) {
                    stack.push(order[i]);
                } else {
                    result[start] = order[i];
                    start++;
                }
            }

            result[start] = order[order.length-1];

            if(!(stack.empty()) && stack.peek() < result[start]){
                check = false;
            } // so sanh ptu dau stack vs cuoi mang result

            while (!(stack.empty()) && stack.size() > 1 ) {
                if (stack.pop() > stack.get(stack.size() - 1) ) {
                    check = false;
                }
            } // so sanh ptu trong stack

            for (int i = 0; i < start-1; i++) {
                if (result[i] > result[i + 1]) {
                    check = false;
                }
            } // so sanh phan tu trong result
        }
        if (check)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
