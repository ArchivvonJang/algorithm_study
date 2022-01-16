package yun;

import java.util.LinkedList;
import java.util.Queue;

//queue
public class 네트워크 {
	int answer = 0;
	boolean[] visited;

	public int Solution(int[][] computers, int n) {
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			if(visited[i]) {
				continue;
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(i);
			visited[i] = true;
			
			//탐색 시작
			while(!q.isEmpty()) {
				int computer = q.poll();
				
				for(int j=0; j<n; j++) {
					
					if(j == computer || visited[j]) {
						continue;
					}
					if(computers[computer][j] == 1) {
						q.offer(j);
						visited[j] = true;
					}
				}
			}
			answer++;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		네트워크 sol = new 네트워크();
		int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};//1
//		int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};//2
		int n = 3;
		System.out.println(sol.Solution(computers, n));
	}

}
