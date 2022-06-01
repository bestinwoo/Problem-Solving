import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> str = new ArrayList<>();
        for (int number : numbers) {
            str.add(String.valueOf(number));
        }

        str.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));
        if(str.get(0).equals("0")) {
            return "0";
        }
        return String.join("", str);
    }

}