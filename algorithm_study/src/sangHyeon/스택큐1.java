import java.util.*;

public class 스택큐1 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(new Solution().solution(progresses, speeds)));
    }

    static class Solution {
        List<Integer> ret = new ArrayList<>();
        Queue<Integer> q = new LinkedList();
        int day = 0;
        int priority_progress_idx = 0;
        int developed_progress_count = 0;
        boolean is_developed;

        void develope_finish() {
            q.poll();
            priority_progress_idx++;
            developed_progress_count++;
            is_developed = true;
        }

        public int[] solution(int[] progresses, int[] speeds) {
            //작업의 갯수가 1개 일때는 [ 1 ] 리턴
            if (progresses.length < 2) return new int[]{1};
            //큐에 차례대로 대입
            for (int progress : progresses) q.offer(progress);
            //큐에 아무것도 없을 때까지 반복
            while (!q.isEmpty()) {
                //완료된 작업갯수, is_developed 초기값으로 리셋
                developed_progress_count = 0;
                is_developed = false;
                //큐에 아직 작업이 있고, 제일앞에 있는 작업의 진행도가 100이상일 때까지 반복
                while (!q.isEmpty() && q.peek() + (speeds[priority_progress_idx] * day) >= 100) {
                    develope_finish();
                }
                //개발완료된 작업이 있을 경우 개발된 작업의 갯수를 ret에 추가
                if (is_developed) ret.add(developed_progress_count);
                //다음날로 넘어감
                day++;
            }
            return Arrays.stream(ret.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
        }

    }
}
