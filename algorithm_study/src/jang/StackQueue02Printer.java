package jang;

import java.util.*;

// 스택/큐 02 프린터
//1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
//2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
//3. 그렇지 않으면 J를 인쇄합니다.

public class StackQueue02Printer {

    public int solution(int[] priorities, int location) {

        int answer = 0;
        // 1. 큰 수가 우선순위를 갖는 PriorityQueue 선언
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
            // PriorityQueue : 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나오는 것
            // Collections.reverseOrder() : 배열을 내림차순으로 정렬

        // 2. priorities값을 우선순위 큐에 담는다.
        for(int n : priorities){

            que.offer(n);
            // offer/ add 둘다 enqueue(추가)를 수행하지만,
            // 큐가 overflow인 경우에 add는 return 예외 / offer는 return false
        }

        // 3. 모든 대기목록이 비워질 때 까지(큐가 비어질 때) 반복한다.
        while(!que.isEmpty()){

            // 4. 큐에서 꺼낸 데이터와 같은 경우를 탐색한다.
            for(int i = 0; i<priorities.length; i++){ // i == index == 데이터의 위치 == 찾을 location

                // 5. 데이터가 일치하는 경우 해당 문서 출력한다.
                if(que.peek() == priorities[i] ){

                    que.poll();
                    answer++;

                    // 6. 값과 위치가 모두 일치하면 answer을 반환한다.
                    if(location == i )
                        return answer;
                }
            }

        }

        return answer;

    }


    public static void main(String[] args) {
        int [] priorities = {2, 1, 3, 2};
        int [] location = {2};

        System.out.println(new StackQueue02Printer());

    }
}
