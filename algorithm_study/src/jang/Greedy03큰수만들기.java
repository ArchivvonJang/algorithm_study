package jang;

import java.util.Stack;

public class Greedy03큰수만들기 {

    static String solution(String number, int k) {

        int length = number.length() - k;
        char[] answer = new char[length];
        Stack<Character> stack = new Stack<>();

        //순서대로 현재수보다 다음수가 크면 현재숫자를 제거한다.
            for (int i = 0; i < number.length(); i++) {

                char c = number.charAt(i);

                while(!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                    stack.pop();
                }
                stack.add(c);
            }

            for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
            }

            return new String(answer);

}
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;
        System.out.println(solution(number, k));
    }

}
