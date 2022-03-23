package yun;

public class 등굣길 {
	public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];//문제에서 시작 위치가 [1,1]어서 +1

        //시작위치를 1로 초기화
        dp[1][1] = 1;
        //웅덩이들 -1로 초기화
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 웅덩이는 0 으로 바꾸고 넘어간다.
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    if (i == 1) {//i=1은 첫번째 줄-> 왼쪽값만 더해주면 된다.
                        dp[i][j] += dp[i][j - 1];
                    } else {//왼쪽과 위에 값을 더해준다.
                        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                    }
                }

                //마지막 값 answer
                if (j == dp[i].length - 1) {
                    answer = dp[i][j];
                }
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		등굣길 a = new 등굣길();
		System.out.println(a.solution(4, 3, new int[][] {{2,2}}));

	}

}
