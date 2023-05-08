import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ARRANGE {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[] array = new int[n];
            int count1 = 0, count = 0, input, j = 0;
            String[] inputLine = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                input = Integer.parseInt(inputLine[i]);
                if (input == 1)
                    count1++;
                else {
                    array[j++] = input;
                    count++;
                }
            }
            Arrays.sort(array, 0, count);
            for (int i = 0; i < count1; i++)
                result.append("1 ");
            if (count == 2 && array[0] == 2 && array[1] == 3)
                result.append("2 3");
            else {
                for (int i = count - 1; i >= 0; i--)
                    result.append(array[i] + " ");
            }
            result.append("\n");
        }
        System.out.print(result);
        reader.close();
    }
}
