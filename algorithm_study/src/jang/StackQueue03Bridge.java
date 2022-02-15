package jang;

import java.util.LinkedList;
import java.util.Queue;

// 스택/큐 다리를 지나는 트럭
public class StackQueue03Bridge {
                            // 다리길이, 다리가 견딜 수 있는 무게, 트럭별 무게
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // 첫번째 트럭이 올라가는 경우
        // n번째 트럭이 올라가는 경우 : n-1번째 트럭의 무게 + n번째 트럭의 무게 < 다리가 견딜 수 있는 무게
        // n-1번째 트럭의 무게 + n번째 트럭의 무게 > 다리가 견딜 수 있는 무게인 경우 : n - 1
        // 다리의 길이 => Queue size()
        // size == 다리의 길이 : 먼저 출발한 트럭이 끝에 도착! (1번예제 다리 길이가 2이면 첫번재 트럭이 도착하는데 2초 걸림)

        // 0. 모든 트럭이 다리를 통과하는 데 걸린 시간(초)
        int answer = 0;

        // 1. 마지막 트럭을 제외한 모든 트럭이 다리를 통과하는 데 걸린 시간
        int sec = 0;

        // 2. 현재 다리의 트럭 무게 총합, 트럭들의 무게를 참조 할 변수
        int temp_weight = 0, idx=0;

        // 3. 다리
        Queue<Integer> que = new LinkedList<>();

        // 4. 마지막 트럭을 제외한 모든 트럭을 통과시키기 위한 무한 반복한다.
        while(true){

            // 5. 마지막 트럭이 다리에 올라갔을 때, 벗어난다.
            if(idx == truck_weights.length)break;

            // 6. 다리에 있는 트럭이 끝에 도달하면, 도달한 트럭의 무게를 현재 다리의 트럭 무게 총합에서 빼준다.
            if(que.size() == bridge_length){
                temp_weight-=que.poll();
            }
            // 7. 현재 다리의 트럭 무게 총합 + 다리에 올라가야 하는 트럭의 무게 > 다리의 하중인 경우
            else if(temp_weight+truck_weights[idx]>weight){
                // 7-1. 다리의 길이를 고려하기 위해 0인 값을 넣어 자리를 채우고, 1초 증가시킨다.
                que.offer(0);
                sec++;
                // 8. 위를 제외하고는 다리에 트럭이 올라간다.
            }else{
                que.offer(truck_weights[idx]);
                temp_weight+=truck_weights[idx];
                sec++;
                idx++;
            }
        }
        // 9. 마지막 트럭이 다리에 올라간 상태에서 다리의 길이를 더해주면, 모든 트럭이 통과하는데 걸린 시간.
        answer = sec + bridge_length;

        return answer;
    }
}
