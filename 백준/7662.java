import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> q = new TreeMap<>();
            for(int j = 0; j < k; j++) {
                String[] operation = br.readLine().split(" ");
                char oper = operation[0].charAt(0);
                int num = Integer.parseInt(operation[1]);

                if(oper == 'I') {
                    q.put(num, q.getOrDefault(num, 0) + 1);
                } else {
                    if(q.isEmpty()) {
                        continue;
                    }
                    int val = num == 1 ? q.lastKey() : q.firstKey();
                    if(q.put(val, q.get(val) - 1) == 1) {
                        q.remove(val);
                    }
                }
            }
            if(!q.isEmpty()) {
                System.out.println(q.lastKey() + " " + q.firstKey());
            } else {
                System.out.println("EMPTY");
            }
        }
    }
}