package moon;

import java.util.Arrays;
// 힘든 점
// 문제를 이분탐색으로 찾아야겠다고 생각하는 것
// 어떤 값을 이분 탐색할 값으로 둘지 정하는 것
public class BinarySearch_입국심사 {
    public long solution(int n, int[] times) {
        long needSec = 0;
        Arrays.sort(times); // 이분탐색을 위해 정렬
        long left = 0;
        long right = (long) n * times[times.length-1]; // 최대로 소요될수있는 시간
        while (left <= right) {
            long mid = (left + right) / 2;  // 중간
            long sum = 0;   // 각 심사대들이 처리할 사람수
            // 특정 시간까지 처리할 수 있는 사람수를 모두 구하
            for (int time : times) {
                sum += mid / time;  // 각 심사대에서 처리할 수 있는 사람수를 모두 sum에 ++
            }
            if (sum < n) // 심사해야하는 수보다 적게 채우면 더 시간을 늘려야 한다
                left = mid +1;
            else {  // 해야할 인원보다 더 많이 혹은 알맞게 처리한 경우, left, right가 크로스될 때까지 범위를 좁혀나가도록 right을 재설정
                right = mid-1;
                needSec = mid;
            }
        }
        return needSec;
    }

    public static void main(String[] args) {
        BinarySearch_입국심사 t = new BinarySearch_입국심사();
        System.out.println(t.solution(6, new int[]{7, 10}));
    }
}

// 0 60  (첫 left와 right)
// 0 '30' 60    -> answer = 30
// 0 '14' 30 ..
// 0 14 '22' 30 ..
// 0 14 22 '26' 30 ..
// 0 14 22 26 '28' 30 .. -> answer = 28
// 0 14 22 26 '27' 28 30 .. -> left > right 되면서 종료
// ★ 이분탐색으로 지정되는 mid값(시간초)까지 각 심사대가 심사할 수 있는 사람수 합(sum)이 n보다 클 때 answer를 구할 수 있는데, 중요한 것은 left와 right이 만나서 크로스될 때까지 지속해야 가장 최소의 소요시간을 찾을 수 있다.
// 즉, 30초 소요되서 7명을 처리하는게 아닌, 28초까지만 소요해서 7명을 처리할 수 있다. (처리 수는 소요시간(mid) / 각 심사대의 소요시간(times[i]) 의 합으로 구한다.)