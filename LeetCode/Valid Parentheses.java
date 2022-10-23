import java.util.Stack;
//LeetCode Valid Parentheses
class Solution {
    public boolean isValid(String s) {
        Stack<Character> sa = new Stack<>();
        boolean answer = true;
        for (char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                sa.push(c);
            } else {
                if(!sa.isEmpty() && answer) {
                    Character pop = sa.pop();
                    switch (pop) {
                        case '(':
                            answer = c == ')';
                            break;
                        case '[':
                            answer = c == ']';
                            break;
                        case '{':
                            answer = c == '}';
                            break;
                    }
                } else {
                    answer = false;
                    break;
                }
            }
        }
        if(!sa.isEmpty()) answer = false;
        return answer;
    }
}
