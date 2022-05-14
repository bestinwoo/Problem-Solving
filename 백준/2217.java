import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] rope = new Integer[n];
        for(int i = 0; i < n; i++) {
            rope[i] = sc.nextInt();
        }
        Arrays.sort(rope, Comparator.reverseOrder());
        int max = rope[0];

        for(int i = 1; i < rope.length; i++) {
            if(max < rope[i] * (i+1)) {
                max = rope[i] * (i+1);
            }
        }
        System.out.println(max);
    }
}

