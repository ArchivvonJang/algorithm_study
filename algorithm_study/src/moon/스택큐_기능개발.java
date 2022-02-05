package moon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 작업을 넣은 순서로 빼는 것이니까 큐(LinkedList)
public class 스택큐_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> qu = new LinkedList<Integer>();
        for (int i=0; i<progresses.length; i++)
            qu.add((int) Math.ceil((100-progresses[i]) /Double.valueOf(speeds[i])));   // 남은 작업량

        List<Integer> answerList = new ArrayList<>();
        // 오른쪽보다 작으면 작업갯수+1하고 리셋
        // 오른쪽보다 크면, 계속 더하다가, 오른쪽보다 작으면 그때 작업 갯수를 더함.
        int taskNum=1;
        int max = qu.poll();
        while(!qu.isEmpty()) {
            int task = qu.poll();
            if (max < task) {   // max보다 큰 작업량이면
                answerList.add(taskNum);    // 추가하고 리셋
                max = task;
                taskNum = 1;
            }
            else if (max >= task) { // max보다 작은 작업량이면 기다려야하니 ++
                taskNum++;
            }
        }
        // list에 못 들어간 마지막 taskNum 추가
        answerList.add(taskNum);

        return answerList.stream().mapToInt(num->num).toArray();
    }

    public static void main(String[] args) {
        int[] progresses1 = new int[]{93, 30, 55};
        int[] speeds1 = new int[]{1, 30, 5};
        int[] progresses2 = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds2 = new int[]{1, 1, 1, 1, 1, 1};

        스택큐_기능개발 k = new 스택큐_기능개발();
        int[] answer = k.solution(progresses1, speeds1);
        for (int i : answer) {
            System.out.println(i + ", ");
        }
    }
}
