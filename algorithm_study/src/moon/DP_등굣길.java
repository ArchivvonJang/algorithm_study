package moon;
// 이동 가능 방향 : [i+1][j], [i][j+1]
// 들어갈 값은 이전 위치 % NUM을 더한 값
public class DP_등굣길 {
    public static void main(String[] args) {
        DP_등굣길 k = new DP_등굣길();
        System.out.println(k.solution(4, 3, new int[][]{{2, 2}}));
    }
    static final int NUM = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        // m이 열, n이 행
        int[][] map = new int[n+1][m+1];    // 1,1부터시작이니까
        // 웅덩이를 map에 -1로 체크
        for (int i=0; i<puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1; // 열과 행이 반대 주의!
        }
        map[1][1] = 1;  // 시작 지점의 경우
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                if (map[i][j] == -1) continue;  //웅덩이인 경우 계산x
                if (map[i-1][j] > 0) map[i][j] += map[i-1][j] % NUM;    // 왼쪽에서부터 오는 경우 +
                if (map[i][j-1] > 0) map[i][j] += map[i][j-1] % NUM;    // 위에서부터 오는 경우 +
            }
        }
        return map[n][m] % NUM;
    }
}
