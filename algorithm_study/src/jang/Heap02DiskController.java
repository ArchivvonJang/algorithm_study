package jang;

import java.util.Arrays;
import java.util.PriorityQueue;

// 힙 디스크컨트롤러
public class Heap02DiskController {

    // 대기 큐에 모든 작업을 넣고 요청시간 오름순으로 정렬
    // 수행시간이 짧은 작업부터 처리 SJF(Shortest Job First)

    public int solution(int[][] jobs) {

        int idx = 0; // jobs 배열의 index
        int endTime = 0; // 작업 종료 시간
        int workTime = 0;//작업의 요청부터 정료까지 걸린 시간


        // jobs를 [0][]자리를 오름차순으로 정렬한다. -> 작업의 요청되는 시점(요청시간)이 빠른 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        //우선순위 큐에 int 배열을 받은 후, [][1] 자리를 오름차순으로 정렬한다. -> 작업 소요시간이 짧은은순으로 정렬
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1]-b[1]);

        //요청이 모두 수행될 때까지 반복
        while(idx < jobs.length || !que.isEmpty()){

            // 하나의 작업이 완료되는 시점(요청시간이 현재시간보다 작거나 같은 요청시점)까지 들어온 모든 요청을 큐에 담는다.
            while(idx < jobs.length && jobs[idx][0] <= endTime){
                que.offer(jobs[idx++]);
            }

            //큐가 비어있다면(현재시점에서 처리할 수 있는 요청이없다면) 작업 완료 시간 이후에 다시 요청이 들어온다. -> time 요청의 가장 처음으로 설정해준다.
            if(que.isEmpty()) {
                //작업 요청시점이 가장 빠른 작업을 추가한다.
                endTime = jobs[idx][0];

            //작업이 끝나기 전 (time 전) 큐에 작업이 있다면, 들어온 작업 요청 중 가장 수행시간이 짧은 요청부터 수행힌다.
            }else{
                //작업소요시점이 가장 빠른 작업 수행
                int[] job = que.poll();
                //작업을 하나 마친 후 종료시간 변경
                endTime += job[1];
                // 요청시간부터 종료시간까지 -> 종료시간 - 작업시작시간
                workTime += endTime - job[0];
            }


        }

        return (int)Math.floor(workTime / jobs.length);
    }
    public static void main(String[] args) {

        //[작업이 요청되는 시점, 작업의 소요시간]
        int[][] job = {{0, 3},{1, 9},{2, 6}};

        Heap02DiskController h2 = new Heap02DiskController();
        System.out.println(h2.solution(job));
    }
}
