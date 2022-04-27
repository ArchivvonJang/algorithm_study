
package jang;
//그래프 - 순위
public class Graph02순위 {
    //플로이드 와샬 알고리즘? 거쳐가는 정점을 기준으로 최단 거리를 구하는 것
    //[순위] 1,3,4 -> 2 -> 5

    public int solution(int n, int[][] results){
        int answer = 0;
        boolean[][] game = new boolean[n][n];

        //경기는 본인을 제외하고 4번 이루어지므로 경기결과는 총 4개
        //배열 0부터 시작하도록 -1해준다.
        for (int i = 0; i < results.length; i++) {
            game[ results[i][0]-1] [results[i][1]-1 ] = true;
        }
        /*
         * 이긴선수\진선수
         *  1 2 3 4 5
         * 1 0 1 0 0 0
         * 2 0 0 0 0 1
         * 3 0 1 0 0 0
         * 4 0 1 1 0 0
         * 5 0 0 0 0 0
         */

        //i -> j, j -> k 라면 i -> k
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(game[j][i] && game[i][k]) game[j][k] = true;
                }
            }
        }
        /*  0 1 2 3 4
         *   1 2 3 4 5
         * 1 0 1 0 0 1
         * 2 0 0 0 0 1
         * 3 0 1 0 0 1
         * 4 0 1 1 0 1
         * 5 0 0 0 0 0
         */

        //1:1 경기이므로 i : j
        for (int i = 0; i < n; i++) {
            int result = 0; //경기결과

            for (int j = 0; j < n; j++) {
                // a선수가 b선수를 이겼거나 졌다면(true) 경기결과(result)를 +1을 해준다.
                if(game[i][j] || game[j][i]) result++;
            }

            // 경기결과의 중복없이 n-1회 경기결과
            // --> 경기결과가 4회를 충족할 때 순위를 +1해준다.
            if(result ==  n-1) answer++;
        }
        return answer;
    }


}
