/*
package moon;

import java.util.Collections;
import java.util.LinkedList;

public class 스택큐_프린터2 {
    private static class PaperInfo implements Comparable<PaperInfo> {
        int index;
        char paperName;
        int priority;

        PaperInfo(int index, char paperName, int priority) {
            this.index = index;
            this.paperName = paperName;
            this.priority = priority;
        }

        @Override
        public int compareTo(PaperInfo p) {
            if (p.priority == this.priority) {
                return this.index - p.index; // 적은 인덱스가 먼저
            }
            return p.priority - this.priority;    // 내림차순
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<PaperInfo> qu = new LinkedList<>();

        // 1. location에 해당하는 문서 구함 & PaperInfo 인스턴스 생성해서 queue 추가 & 최댓값 구하기
        char answerName = ' ';
        char alphabet = 'A';
        int maxPriority = priorities[0];
        for (int i=0; i<priorities.length; i++, alphabet++) {
            qu.add(new PaperInfo(i, alphabet, priorities[i]));
            if (maxPriority < priorities[i])
                maxPriority = priorities[i];
        }

        // 한바퀴돌기
        int maxPriority =
        for (int i=0; i<priorities.length; i++, alphabet++) {

        }
        // 2. 내림차순 정렬 sort
        Collections.sort(qu);


        PaperInfo paper;
        int outputNumber = 0;
        while (true) {
            paper = qu.peek();
            if (maxPriority <= paper.priority) {
                outputNumber++;
                if (answerName == paper.paperName) {  // char니까 == 가능
                    answer = outputNumber;
                    break;
                }
            }
            else
                qu.add(paper);
        }
        // aswer 알파벳에 해당하는 인쇄 순서 return
        return answer;
    }
}
*/
