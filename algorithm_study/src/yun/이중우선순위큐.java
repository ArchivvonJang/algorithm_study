package yun;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	public int[] solution(String[] operations) {
		int[] answer = {0,0};
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0; i<operations.length; i++) {
			String[] check = operations[i].split(" ");
			
			if(check[0].equals("I")) {
				minQueue.offer(Integer.parseInt(check[1]));
				maxQueue.offer(Integer.parseInt(check[1]));
			}else {
				if(!minQueue.isEmpty()) {
					if(check[1].equals("-1")) {
						int min = minQueue.peek();
						minQueue.remove(min);
						maxQueue.remove(min);
					}else {
						int max = maxQueue.peek();
						minQueue.remove(max);
						maxQueue.remove(max);
					}
				}
			}
		}
		if(!minQueue.isEmpty()) {
			answer[0] = maxQueue.poll();
			answer[1] = minQueue.poll();
		}
        
        return answer;
    }

	public static void main(String[] args) {
		이중우선순위큐 s = new  이중우선순위큐();
//		System.out.println(Arrays.toString(s.solution(new String[] {"I 16","D 1"})));
		System.out.println(Arrays.toString(s.solution(new String[] {"I 7","I 5","I -5","D -1"})));
		
	}

}
