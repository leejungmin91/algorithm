package programmers;

import java.util.Stack;

public class P12973 {

    public static int solution(String s)
    {
        int answer = 0;

        String[] splitS = s.split("");
        Stack<String> stack = new Stack<>();

        int len = splitS.length;
        String temp = "";

        // baabaa

        for(int i=0; i<len; i++){
            stack.push(splitS[i]);
            if(temp.equals(stack.peek())) {
                stack.pop();
                stack.pop();
                temp = stack.isEmpty() ? "" : stack.peek();
            } else {
                temp = splitS[i];
            }
        }

        answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }

    public static void main(String[] args){
        int n = solution("baabaa ");
        System.out.println(n);
    }

}
