package yun;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
	public static void main(String[] args) {
		프린터 p = new 프린터();
//		System.out.println(p.solution(new int[] {2, 1, 3, 2}, 2));
		System.out.println(p.solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
	}
	
	public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
        	q.offer(new Print(priorities[i], i)); //우선순위와 위치정보를 큐에 담아준다
        }
        
        while(!q.isEmpty()) {
        	boolean isUpperPriority = false; //최우선순위인지를 알기 위한 변수 

        	Print print = q.poll();
        	
        	for(Print sub : q) {
        		if(print.priority < sub.priority) { // q의 첫번째 값(print)이 최우선순위인지 확인 
        			isUpperPriority = true;
        			break;
        		}
        	}
        	
        	if(isUpperPriority) { //true=최우선순위가 아님, 최우선순위가 먼저 프린트 되어야하니까 큐 맨뒤에 추가 
        		q.offer(print);
        	}else {//print의 담긴게 최우선순위이면 answer를 늘려준다 
        		answer++;
        		if(print.location == location) { //내가 요청한 문서인지는 처음에 넣어준 location으로 비교한다.
        			break;
        		}
        	}
        }
        return answer;
    }
	
	public class Print{
		private int priority;
		private int location;
		
		public Print(int priority, int location) {
			super();
			this.priority = priority;
			this.location = location;
		}
	}

}


