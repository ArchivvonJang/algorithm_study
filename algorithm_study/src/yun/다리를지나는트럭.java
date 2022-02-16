package yun;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0; //다리위 트럭 무게 합
        
        Queue<Integer> bridge = new LinkedList<Integer>();//다리
        
        for(int i : truck_weights) {
        	while(true) {
        		//다리위가 비어있는 경우
        		if(bridge.isEmpty()) {
        			bridge.offer(i);
        			totalWeight += i;
        			answer++;
        			break;
        		}else if(bridge.size() == bridge_length) {
        			//다리가 꽉 차있는 경우
        			totalWeight -= bridge.poll();
        		}else {
        			//다리가 비어있지도, 꽉 차지도 않은 경우
        			if(i + totalWeight > weight) {//견디는 무게보다 큰 경우
        				bridge.offer(0);
        				answer++;
        			}else {//견디는 무게보다 작은 경우
        				bridge.offer(i);
        				totalWeight += i;
        				answer++;
        				break;
        			}
        		}
        	}
        }
        //다리위에 있는 모든 트럭이 지나가야되기 때문에 다리길이를 더해줌 
        return answer + bridge_length;
    }
	
	public static void main(String[] args) {
		다리를지나는트럭 p = new 다리를지나는트럭();
		System.out.println(p.solution(2, 10, new int[] {7,4,5,6}));

	}

}
