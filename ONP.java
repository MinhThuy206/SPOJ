import java.util.Scanner;
import java.util.Stack;

public class ONP {
    // Trả về true nếu kí tự ch là toán hạng
    public static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    // Trả về true nếu kí tự ch là toán tử
    public static boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
            return true;
        }
        return false;
    }

    // Trả về độ ưu tiên cho các toán tử
    public static int getPriority(char ch) {
        if (ch == '+') {
            return 1;
        } else if (ch == '-') {
            return 2;
        } else if (ch == '*') {
            return 3;
        } else if (ch == '/') {
            return 4;
        } else if (ch == '^') {
            return 5;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line sau khi đọc T

        for (int tc = 0; tc < T; tc++) {
            String infix = scanner.nextLine();
            int length = infix.length();

            Stack<Character> stack = new Stack<>();

            // Thực hiện theo thuật toán
            for (int i = 0; i < length; i++) {
                char ch = infix.charAt(i);
                if (isOperand(ch)) {
                    System.out.print(ch);
                } else if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    while (!stack.empty() && stack.peek() != '(') {
                        System.out.print(stack.pop());
                    }
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    }
                } else if (isOperator(ch)) {
                    while (!stack.empty() && isOperator(stack.peek()) &&
                            (getPriority(stack.peek()) >= getPriority(ch))) {
                        System.out.print(stack.pop());
                    }
                    stack.push(ch);
                }
            }

            while (!stack.empty()) {
                System.out.print(stack.pop());
            }
            System.out.println();
        }
        scanner.close();
    }
}
