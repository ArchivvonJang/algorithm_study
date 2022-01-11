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
			if(visited[i]) { //true = 이미 방문한 노드 = 통
				continue;
			}
			
			//false인 노드(방문하지 않은)
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(i); // 큐에 => 0
			visited[i] = true; //t, f, f
			answer++;
			
			//탐색 시작
			while(!q.isEmpty()) {
				int computer = q.poll(); // 0
				
				for(int j=0; j<n; j++) {
					// 자기 자신이거나 방문한 노드면 건너뛰기
					if(j == computer || visited[j]) { // 0 || true
						continue;
					}
					System.out.println("computer=>"+computer);
					System.out.println("j=>"+j);
					System.out.println("=>"+computers[computer][j]);
					if(computers[computer][j] == 1) {
						q.offer(j);
						visited[j] = true;
					}
				}
			}
		}
		return answer;
	}
	
	
	public static void main(String[] args) {
		네트워크 sol = new 네트워크();
//		int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};//1
		int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};//2
		int n = 3;
		System.out.println(sol.Solution(computers, n));
	}

}
