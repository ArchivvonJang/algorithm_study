package moon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// SJF : 평균 대기시간을 최소로 만드는 걸 최적으로 두고 있는 알고리즘
// 비선점형 스케줄링
public class 힙_디스크컨트롤러 {
    public int solution(int[][] jobs) {
        Queue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[1]-o2[1]);   // 추가될 작업큐는 작업시간을 기준으로 정렬
        // 도착시간을 기준으로 정렬
       Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        /*Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] <= o2[0])
                    return -1;
                return 1;
            }*/

        // 도착시간대로 작업큐에 추가하면서 처리
        int len = jobs.length;  // 수행된 작업 갯수
        int endTime = 0;    // 종료 시간
        int jobsIdx =0;
        int pureTime=0;     //  순 작업 시간
        while(jobsIdx < len || !pq.isEmpty()) {   // 모든 작업 처리하거나 큐가 비면 종료
            // 작업의 도착 시간이 종료시간보다 작거나 같은 작업들 작업큐에 등록
            while (jobsIdx < len && jobs[jobsIdx][0] <= endTime) {
                pq.add(jobs[jobsIdx]);
                jobsIdx++;
            }
            // 작업큐에 작업이 없으면 그다음 작업의 도착 시간을 종료시간으로 갱신 (대기)
            if (pq.isEmpty())
                endTime = jobs[jobsIdx][0];
            // 작업큐에 작업이 있으면 작업을 빼서 종료시간&소요 시간 지정
            else {
                int[] j = pq.poll();
                endTime += j[1]; // 종료 시간 지정
                pureTime += endTime -j[0]; // 종료시간 - 도착시간 + 작업시간 == 순 작업 시간
            }
        }
        return pureTime/len;
    }
}