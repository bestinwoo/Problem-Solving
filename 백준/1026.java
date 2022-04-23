import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ans = 0;
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0) {
                    a.add(in.nextInt());
                } else {
                    b.add(in.nextInt());
                }
            }
        }

        a.sort(Comparator.naturalOrder());

        for (int i = 0; i < n; i++) {
            int max = b.stream()
                    .max(Comparator.comparing(x -> x)).orElseThrow();
            ans += a.get(0) * max;
            a.remove(0);
            b.remove(b.indexOf(max));
        }
        System.out.println(ans);
    }
}

