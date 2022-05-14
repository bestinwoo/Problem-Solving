import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int index = 0;
        String expression = sc.next();
        String[] split = expression.split("-");
        for (String s : split) {
            String[] split1 = s.split("\\+");
            int sum = 0;

            for (int i = 0; i < split1.length; i++) {
                sum += Integer.parseInt(split1[i]);
            }

            if(index == 0) {
                answer = sum;
            } else {
                answer -= sum;
            }
            index++;
        }
        System.out.println(answer);
    }
}

