package jang;

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

        for(int i = 0; i < scoville.length; i++){
            que.add(scoville[i]);
        }

        while (que.peek() < K){
            //음식 중에 섞어도 K 이상의 스코빌 지수를 가질 수 없으면 -1을 반환
            if(que.size() < 2) return -1;

            int a = que.poll();
            int b = que.poll();

            que.add(a + (b * 2));

            answer++;
        }

        return answer;
    }
}
