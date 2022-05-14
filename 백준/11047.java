import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        arr.sort(Comparator.reverseOrder());

        while(k > 0) {
            for (Integer integer : arr) {
                if(integer <= k) {
                    k -= integer;
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}

