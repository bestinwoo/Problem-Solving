class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        //1단계
        answer = answer.toLowerCase();
        //2단계 ~!@#$%^&*()=+[{]}:?,<>/
        answer = answer.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", "");
        //3단계
        answer = answer.replaceAll("\\.{2,}", ".");
        //4단계
        answer = answer.replaceAll("^[.]|[.]$", "");
        //5단계
        if(answer.isEmpty()) answer = "a";
        //6단계
        if(answer.length() >= 16) answer = answer.substring(0, 15);
        answer = answer.replaceAll("[.]$", "");
        while(answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}