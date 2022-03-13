package moon;

public class DP_정수삼각형 {
    static int[][] sumTriangle;
    public int solution(int[][] triangle) {
        //input과 같은 크기의 배열 생성
        sumTriangle = new int[triangle.length][triangle.length];    // 수정)정수 삼각형이므로 각 층의 길이도 전체 층의 길이를 넘지 않으므로, 반복문을 돌지 않고 층의 길이로 초기화해줘도 됨.

        // 각 층을 반복
        sumTriangle[0][0] = triangle[0][0];
        for (int i=1; i<triangle.length; i++) {
            sumTriangle[i][0] = sumTriangle[i-1][0] + triangle[i][0];   // 맨 앞
            sumTriangle[i][triangle[i].length-1] = sumTriangle[i-1][triangle[i].length-2] + triangle[i][triangle[i].length-1];  // 맨 끝
            // 중간 원소들 반복
            for (int j=1; j< triangle[i].length-1; j++) {
                sumTriangle[i][j] = Math.max(sumTriangle[i-1][j-1], sumTriangle[i-1][j]) + triangle[i][j];
            }
        }
        // 마지막 층에서 최댓값 구하기
        return getLastLevelmax();
    }

    private int getLastLevelmax() {
        int lastLevelIdx = sumTriangle.length-1;
        int answer = -1;
        for (int i=0; i<sumTriangle[lastLevelIdx].length; i++) {
            answer = Math.max(answer, sumTriangle[lastLevelIdx][i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        DP_정수삼각형 k = new DP_정수삼각형();
        System.out.println(k.solution(triangle));
    }
}
