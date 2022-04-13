package moon;
import java.util.Arrays;
import java.util.Comparator;

// ★ 각 진입/진출 지점으로 생각해야 한다.
// ★ 먼저 빨리 빠져나가는 차량부터 순차적으로 카메라를 설치해야 한다.
// ★ 카메라가 설치될 곳은 가장 먼저 빠져나가는 차량의 진출 지점. 그지점까지 통과하는 모든 차량 또한 true 체크한다.
public class Greedy_단속카메라 {
    int carNum;
    int answer = 0;
    boolean[] captured;
    public int solution(int[][] routes) {
        carNum = routes.length;
        captured = new boolean[carNum];
        // 1. 가장 빨리 진출하는 차량을 먼저 체크해야하므로, routes[][1] 기준으로 Sorting
        Arrays.sort(routes, Comparator.comparingInt(r1->r1[1]));

        // 2. routes 반복문 돌며 진출 지점 기준으로 포함되는 차량 체크 & answer++
        for(int i=0; i<carNum; i++){
            // 3. 카메라를 만나지 못한 차만 if문 로직 수행
            if (!captured[i]) {
                checkInvolvedCar(i, routes);
                answer++;   // 차량 1개일지라도 설치는 해야함
            }
        }
        return answer;
    }
    // 해당 지점에 통과하는 차량 모두 체크한다.
    private void checkInvolvedCar(int nowIdx, int[][] routes) {
        for (int i=nowIdx+1; i<carNum; i++) {
            if (routes[i][0]<= routes[nowIdx][1]) captured[i] = true;
            else return;
        }
    }
}
