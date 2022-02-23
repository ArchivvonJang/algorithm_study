package jang;

import java.util.Arrays;
import java.util.PriorityQueue;

// 힙 - 더 맵게
// Heap  데이터를 입력하면 자동으로 우선순위에 따라 정렬해주는 자료구조
// 우선순위 큐사용
public class Heap01Scoville {

    public int solution(int[] scoville, int K) {

        int answer = 0; // 반환값

        // Leo의 기괴한 취향을 도와주는 문제!
        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

        PriorityQueue<Integer> que = new PriorityQueue<>();

        //1. 스코빌을 큐에 담아준다.
        for(int i = 0; i < scoville.length; i++){
            que.add(scoville[i]);
        }

        //2. 큐에서 꺼낸 값이 K를 넘지 않는 한에서 반복
        while (que.peek() < K){

            //3. 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return
            if(que.size() < 2) return -1;

            //4. a와 b를 큐에서 꺼낸 후
            int a = que.poll();
            int b = que.poll();

            //5. 스코빌 지수를 계산하고
            que.offer(a + (b * 2));

            //6. K 이상이 되면 answer +1 반복문을 나온다.
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] scoville = new int[] {1, 2, 3, 9, 10, 12 };
        int k = 7;
        Heap01Scoville h = new Heap01Scoville();
        System.out.println(h.solution(scoville, k));

    }

}
