import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] nums = new int[N+1];
            for(int j = 1; j <= N; j++) {
                nums[j] = sc.nextInt();
            }
            int cnt = 1;
            int person = nums[1];
            while(person != N && cnt <= N) {
                person = nums[person];
                cnt++;
            }
            if(cnt > N) cnt = 0;
            System.out.println(cnt);

        }

    }

}