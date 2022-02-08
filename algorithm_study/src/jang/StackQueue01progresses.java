package jang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 스택/큐 01 기능개발
public class StackQueue01progresses {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        // 남은 작업일수를 저장할 큐
        Queue<Integer> que = new LinkedList<>(); // LinkedList를 쓰는 이유는?
        // 작업 결과를 담을 배열
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < speeds.length; i++){
            // 남은 작업 일을 계산해서 큐에 추가
           que.add((int)Math.ceil((double) (100 - progresses[i])/ speeds[i]));
        }

        int cnt = 1; //
        int front = que.poll(); // 첫번째 항목 꺼내기

        while(!que.isEmpty()){

            int next = que.poll(); // 다음 작업 꺼내기 - 현재 작업일과 다음 작업일을 비교하기 위해 값을 꺼낸다.


            System.out.println("next : " + next);
            System.out.println("front : " + front);

            if(front < next){ // 첫번째 기능보다 뒤의 기능이 늦게 완료되는 경우
                result.add(cnt);
                System.out.println("1 cnt : " + cnt);
                front = next; //꺼낼 작업을 다음 작업으로 교체
                cnt = 1; //초기화

            }else { // 첫번째 기능보다 뒤의 기능이 먼저 완료되거나 동시에 완료되는 경우
                cnt ++; //현재 작업일이 더 많을 경우 cnt ++
                System.out.println("2 cnt : " + cnt);
            }

        }
        result.add(cnt); // cnt 담아준다.

        // 작업 결과를 담은 result를 배열로 변환
        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int [] progresses = {95, 90, 99, 99, 80, 99};
        int [] speeds = {1, 1, 1, 1, 1, 1};

        StackQueue01progresses sq01  = new StackQueue01progresses();
        System.out.println(sq01.solution(progresses, speeds));

    }
}
