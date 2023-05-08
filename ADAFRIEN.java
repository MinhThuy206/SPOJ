import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADAFRIEN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int q = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<String, Long> expenses = new HashMap<>();

        for (int j = 0; j < q; j++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            long expense = Long.parseLong(st.nextToken());
            expenses.merge(name, expense, Long::sum);
        }

        List<Long> list = new ArrayList<>(expenses.values());
        Collections.sort(list);

        long money=0;
        if(k>list.size()){
            for (Long Long : list) {
                money += Long;
            }
        }else {
            for (int i = list.size() - k; i < list.size(); i++) {
                money += list.get(i);
            }
        }
        System.out.println(money);
    }
}