package moon;
import java.lang.Math;
// Brown + yellow =전체 타일 갯수
// 조건1. 가로&세로>=3 (갈색 타일이 테두리를 감쌀 때의 최소의 길이)
// 조건2. 가로>=세로
// yellow는 테두리를 제외한 내부 타일 갯수 == (가로-2)*(세로-2)
// sqrt로 반복 횟수를 제한해서 w가 3보다 큰지 비교할 필요 x.

public class 완전탐색_카펫 {
    public int[] solution(int brown, int yellow) {
        int w;  // 가로 길이
        int sum = brown + yellow;   // 전체 타일 갯수
        int[] answer = new int[2];
        double sqrt = Math.sqrt(sum);         // 약수(sqrt 이용)

        for (int h=3; h<=sqrt; h++) {    // 조건 1. 3 이상 충족
            if (sum%h==0) { // sum%h==0 으로 나누어 떨어질 때만
                w = sum / h;       // 조건2. 가로 w가 세로 l보다 크거나 같다. + 3보다 항상 크다.
                if ((w-2)*(h-2) == yellow) {        // 테두리를 제외한 길이 == 노란색 타일 갯수일 때
                    answer[0] = w;
                    answer[1] = h;
                }
            }
            break;
        }
        return answer;
    }

    public static void main(String[] args) {
        완전탐색_카펫 k = new 완전탐색_카펫();
        long start = System.nanoTime();
        int[] solution = k.solution(24, 24);
        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");
        for (int i:solution)
            System.out.print(i+ " ");
    }
}