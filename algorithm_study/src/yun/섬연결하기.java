package yun;

import java.util.Arrays;

public class 섬연결하기 {
	static int[] parent;
	
	public int solution(int n, int[][] costs) {
		//가중치 기준으로 오름차순 정렬(크루스칼용)
		Arrays.sort(costs, (int[] o1, int[]o2) -> o1[2]-o2[2]);
        
 
		parent = new int[n];
		//부모는 자기 자신으로 초기화        
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
       
		int answer = 0;
		
		for(int[] edge : costs) {
			int from = edge[0];
			int to = edge[1];
			int cost = edge[2];
			
			int fromParent = findParent(from);//시작 섬 부모 찾기 
			int toParent = findParent(to);//도착 섬 부모 찾기 
			
			if(fromParent == toParent) continue; //두 섬의 부모가 같으면 통과.
			
			answer += cost;
			parent[toParent] = fromParent;//연결 후 부모 노드를 갱신
		}

        return answer;
    }
	
	//부모 노드가 자기 자신일 경우까지 재귀 
	private int findParent(int child) {
		if(parent[child] == child) return child;
		return parent[child] = findParent(parent[child]);
	}

	public static void main(String[] args) {
		섬연결하기 sol = new 섬연결하기();
		System.out.println(sol.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));

	}

}
