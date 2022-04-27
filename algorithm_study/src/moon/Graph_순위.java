package moon;
// 숫자를 이용해서 두자릿수의 모든 조합을 구하는 것과 같음 => dfs로 시도..
// 플로이드-워셜 알고리즘 : 한 번 실행하여 모든 노드 간 최단 경로를 구할 수 있는 알고리즘
// 시간 복잡도가 O(n^3) : '현재 노드를 거쳐 가는 모든 경로'를 고려
// => 그래프의 크기(100*100)가 작아 세제곱 시간 알고리즘을 적용해도 문제가 풀릴 때만 사용할 수 있음
// 2차원 테이블에 최단 거리 정보를 저장
public class Graph_순위 {
    int[][] matchResult;
    public int solution(int n, int[][] results) {
        // 1. 초기화
        matchResult = new int[n+1][n+1];
        for (int i=0; i<results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            checkWinLose(winner, loser);
        }
        // i가 j를 이기고, j가 k를 이기면, i도 k를 이긴다.
        // j가 i를 이기고, k가 j를 이기면, k가 i를 이긴다.
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                for (int k=1; k<=n; k++) {
                    if (matchResult[i][j]==1 && matchResult[j][k]==1) checkWinLose(i, k);
                    if (matchResult[i][j] == -1 && matchResult[j][k] == -1) checkWinLose(k,i);
                }
            }
        }
        int answer = calculAnswer(n);
        return answer;
    }
    private void checkWinLose(int winner, int loser) {
        matchResult[winner][loser] = 1;
        matchResult[loser][winner] = -1;
    }
    // 모든 경기결과를 탐색하며 승패가 n-1개 이상 정해져있다면 순위를 알수있는 선수
    private int calculAnswer(int n) {
        int answer = 0;
        for (int i=1; i<=n; i++) {
            int rankCnt=0;
            for (int j=1; j<=n; j++) {
                if (matchResult[i][j] != 0) rankCnt++;
            }
            if (rankCnt == n-1) answer++;
        }
        return answer;
    }
}