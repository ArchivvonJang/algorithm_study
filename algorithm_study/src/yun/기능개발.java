package yun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<progresses.length; i++) {
        	//작업일수 구하기
        	double remain = (100 - progresses[i]) / (double)speeds[i];
        	int days = (int)Math.ceil(remain);
        	
        	if(!q.isEmpty() && q.peek() < days) { //q에 담겨진 작업일수가 이번 작업일수보다 작다는건 먼저 끝난다는거
        		list.add(q.size());
        		q.clear();
        	}
        	
        	q.offer(days);
        }
        
        list.add(q.size());
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
	public static void main(String[] args) {
		기능개발 a = new 기능개발();
		System.out.println(Arrays.toString(a.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));

	}

}
