package jang;

import java.util.Arrays;
import java.util.Stack;

// 스택/큐 - 주식 가격
public class StackQueue04Prices {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        //주식가격 변화를 시간과 함께 확인 할 stack
        Stack<Integer> stack = new Stack<>();

        //for문을 돌면서 prices의 값 하나하나 확인한다.
        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                //반복문 실행 중 스택이 비어있지 않고, 주식가격이 떨어졌을 때 answer에 값을 넣어준다.
                answer[stack.peek()] = i - stack.peek();
                //해당 인덱스는 stack에서 꺼낸다. (답을 구했으므로 stack에서 제거한다.)
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
    public static void main(String[] args) {

        int[] prices = new int[] { 1, 2, 3, 2, 3 };
        StackQueue04Prices s = new StackQueue04Prices();
        System.out.println(Arrays.toString(s.solution(prices)));

    }

}
