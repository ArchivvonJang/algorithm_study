package yun;

public class 순위 {
	public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd = new int[n+1][n+1]; //경기 결과를 담을 2차원 배열 
        
        //주어진 경기결과로 초기화
        for(int i = 0; i < results.length; i++) {
        	int a = results[i][0];
        	int b = results[i][1];
        	
        	floyd[a][b] = 1;
        	floyd[b][a] = -1;
        }
        
        //플로이드 알고리즘 = 거쳐가는 정점을 기준으로 최단거리를 구하는 알고리즘
        // 1번이 3번한테 이기고, 3번이 5번한테 이겼다면 거쳐가는 정점은 3번이고
        // 결과는 없지만 1번이 5번한테 이긴다는 결론
        for(int i = 1; i<= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		for(int k = 1; k <= n; k++) {
        			if(floyd[i][k] == 1 && floyd[k][j] ==1) {
        				floyd[i][j] = 1;
        				floyd[j][i] = -1;
        			}
        			if(floyd[i][k] == -1 && floyd[k][j] == -1) {
        				floyd[i][j] = -1;
        				floyd[j][i] = 1;
        			}
        		}
        	}
        }
        
        //경기결과를 플로이드 알고리즘으로 채우고
        //n-1번의 경기결과를 가진 선수를 찾는다
        for(int i = 1; i <= n; i++) {
        	int cnt = 0;
        	for(int j = 1; j <=n; j++) {
        		if(floyd[i][j] != 0) {
        			cnt++;
        		}
        	}
        	if(cnt == n-1) {
    			answer++;
    		}
        }
        return answer;
    }

	public static void main(String[] args) {
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		순위 a = new 순위();
		System.out.println(a.solution(n, results));

	}

}
