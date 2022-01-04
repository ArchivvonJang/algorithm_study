package moon;
import java.lang.Math;
// Brown + yellow =전체 타일 갯수
// yellow는 테두리를 제외한 내부 타일 갯수 (가로-2)*(세로-2)
// 조건1. 가로&세로>=3
// 조건2. 가로>=세로
// sqrt로 반복을 제한해서 w가 3보다 큰지 비교할 필요 x.

public class 완전탐색_카펫 {
    public int[] solution(int brown, int yellow) {
        int w;
        int sum = brown + yellow;
        int[] answer = new int[2];
        double sqrt = Math.sqrt(sum);         // 약수(sqrt 이용)

        for (int l=3; l<=sqrt; l++) {    // 조건 1. 3 이상 충족
            w = sum / l;       // 조건2. 가로 w가 세로 l보다 크거나 같다.
            if (sum%l==0) { // sum%l==0이고 w는 l보다 항상 크므로 3보다 항상 큼 (비교할 필요x)
                if ((w-2)*(l-2) == yellow) {                // 테두리를 제외한 길이가 노란색 타일 갯수
                    answer[0] = w;
                    answer[1] = l;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        완전탐색_카펫 k = new 완전탐색_카펫();
        int[] solution = k.solution(24, 24);
        for (int i:solution)
            System.out.print(i+ " ");
    }
}