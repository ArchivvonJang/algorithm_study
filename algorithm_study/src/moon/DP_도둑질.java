package moon;
// 내 생각 (failed)
// D[i][j] = i번째 집에서 끝나는 j번째 방문
// D[2][2] : 2번째 집에서 끝는 2번째 방문 시 최대 money값
// D[i][1]은 i번째 집에서 끝나는 1번째 방문 시 money는 최소인 money값으로 미리 초기화한다.
// 참고
// 1. 첫 집을 방문하고, 마지막 집을 방문하지 않는 dp, "visitFromFirst_dp"
// 2. 첫 집을 방문하지 않는 dp, "ignoreFirst_dp"
// 3. 두 dp 모두 max(전전집 최대비용+자기집 money , 전집 최대비용)를 통해 최댓값으로 채워넣는다.
// 4. 두 dp의 max(마지막 전집, 마지막 집) => 답 도출
public class DP_도둑질 {
    public int solution(int[] money) {
        final int homeNum = money.length;
        // 1. 초기화
        int[] visitFromFirst_dp = new int[homeNum];
        int[] ignoreFirst_dp = new int[homeNum];

        visitFromFirst_dp[0] = visitFromFirst_dp[1] = money[0];    // 첫집 방문 + 둘째집 방문 안하니까 첫째집 money로 최대값 지정
        ignoreFirst_dp[1] = money[1];   // 첫집 방문 안하니까 둘째집 최대비용은 그냥 둘째집의 money

        // 2. 집을 돌면서 dp 값 구하기
        for (int i=2; i<homeNum; i++) {    // i-2, i-1 해야하므로 2부터시작
            ignoreFirst_dp[i] = Math.max(ignoreFirst_dp[i-2]+ money[i], ignoreFirst_dp[i-1]);
            if (i== homeNum-1) break;   // visitFromFirst_dp는 마지막 집 방문 x
            visitFromFirst_dp[i] = Math.max(visitFromFirst_dp[i-2]+ money[i], visitFromFirst_dp[i-1]);
        }
        // 3. 마지막 집과 마지막 전집 비교 ->최댓값
        int answer = Math.max(ignoreFirst_dp[homeNum - 1], visitFromFirst_dp[homeNum - 2]);
        return answer;
    }
}
