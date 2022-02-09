package jang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 스택/큐 01 기능개발
public class StackQueue01progresses {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        // 각 기능은 정해진 순서대로 배포가 가능하기 때문에 입력 순서대로 반환하는 Queue 사용
        // 남은 작업일수를 저장할 큐
        Queue<Integer> que = new LinkedList<>(); // LinkedList를 쓰는 이유는?
        // 작업 결과를 담을 배열
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < speeds.length; i++){
            // 남은 작업 일을 계산해서 큐에 추가
            // 계산한 값이 4.5와 같이 소수점으로 나오게 되면 실제 배포일은 5일이기 때문에 Math.ceil을 통해 올림해준다.
           que.add((int)Math.ceil((double) (100 - progresses[i])/ speeds[i]));
        }

        int cnt = 1; //구현이 완료된 기능의 갯수를 세기 위한 변수
        int completed = que.poll(); // 현재 기능이 완료되는 일자를 꺼내온다.

        while(!que.isEmpty()){

            int next = que.poll();// 다음 기능이 완료되는 일자

           if(completed < next){ // 첫번째 기능보다 뒤의 기능이 늦게 완료되는 경우
              result.add(cnt);
              completed = next; //꺼낼 작업을 다음 작업으로 교체
              cnt = 1; //초기화

           }else { // 첫번째 기능보다 뒤의 기능이 먼저 완료되거나 동시에 완료되는 경우
              cnt++; //현재 작업일이 더 많을 경우 cnt ++

           }
        }
        result.add(cnt); //현재 완료된 기능이 더이상 없다면 List에 개수를 추가

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
