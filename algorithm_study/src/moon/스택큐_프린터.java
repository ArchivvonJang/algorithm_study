package moon;
import java.util.LinkedList;

// 선입선출 => Queue

/**
 * 1149 (+5)
 */
public class 스택큐_프린터 {
    private static class PaperInfo {
        int location;
        int priority;

        PaperInfo(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<PaperInfo> qu = new LinkedList<>();

        // 1. 큐에 인쇄 대기 목록 추가
        for (int i = 0; i < priorities.length; i++) {
            qu.add(new PaperInfo(i, priorities[i]));
        }
        // 2. 앞에서부터 꺼내면서 최댓값이면 출력, 아니면 뒤로
        PaperInfo paper;
        boolean existBigger;
        int outputCnt = 0;
        while (!qu.isEmpty()) {
            paper = qu.poll();
            existBigger = false;
            // 최댓값 체크
            for (PaperInfo p : qu)
                if (paper.priority < p.priority) {  // ★
                    existBigger = true;
                }
            if (existBigger)
                qu.add(paper);
            else {  // 큰게 존재하지않으면
                outputCnt++;
                if (paper.location == location) {
                    answer = outputCnt;
                    break;
                }
            }
        }
        return answer;
    }
}

// A B C D
// 2 1 3 2 : 인쇄 중요도 properities
// location : 내가 요청한 문서의 현재 대기목록 순서

// 1. B C D A
// 2. C D A B
// C인쇄 => 3. D A B
// D인쇄 => 4. A B
// A인쇄
// B인쇄
//  내가 요청한 문서의 인쇄 순서를 알고 싶음
