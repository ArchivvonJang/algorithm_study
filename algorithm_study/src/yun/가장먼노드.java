package yun;

import java.util.*;

public class 가장먼노드 {
	public int solution(int n, int[][] edge) {
        int answer = 0;
        
        //edge에 담긴 그래프 구성 틀을 담을 리스트 생성
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < edge.length; i++){
            list.add(new ArrayList<Integer>());
        }
        
        //생성한 리스트에 주어진 그래프 관계를 담아준다
        int a, b;
        for(int[] node : edge){
            a = node[0];
            b = node[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        int[] count = new int[n + 1]; //1과의 거리를 저장할 배열
        
        boolean[] visited = new boolean[n + 1];// 방문여부
        visited[0] = visited[1] = true; // 0은 안쓰고 1에서 시작
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        int now;
        
        while(!q.isEmpty()){
            now = q.poll();
            for(int v : list.get(now)){
                if(!visited[v]){
                    count[v] = count[now]+1;
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        
        int max = 0;
        for(int depth : count){
            if(max < depth){
                max = depth;
                answer = 1;
            }else if(max == depth) answer++;
        }
        return answer;
    }

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		가장먼노드 a = new 가장먼노드();
		System.out.println(a.solution(n, edge));

	}

}
