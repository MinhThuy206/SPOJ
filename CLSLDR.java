import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CLSLDR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());// number of test cases

        for(int i=0;i<t;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                arr.add(j);
            }
            int current = m; // index of the student who receives the paper first
            while (arr.size() > 1) {
                current = (current + o-1) % arr.size(); // index of the next student who gets the paper
                arr.remove(current); // remove the student who quits the game
            }
            System.out.println(arr.get(0));
        }
    }
}
