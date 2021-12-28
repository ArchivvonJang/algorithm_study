import java.util.ArrayList;
import java.lang.Math;
//1번 : 1,2,3,4,5 (5)
//2번 : 2,1,2,3,2,4,2,5 (8)
//3번 : 3,3,1,1,2,2,4,4,5,5 (10)
// 수포자마다 solveNum 배열을 돌면서 answer와 일치하는지 확인하여 맞은 갯수를 저장
// 맞은 갯수 중 max와 같거나 큰 사람(들)을 오름차순으로 정렬
class 완전탐색_모의고사 {
    public int[] solution(int[] answers) {  //[1,2,3,4,5]
        int[] answer = {};
        int[] correctNum = {0, 0, 0};
        int[][] solveNum= {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        for (int i=0; i<solveNum.length; i++) {
            for (int j=0; j<answers.length; j++) {
                if (solveNum[0][j%5] == answers[j])  correctNum[0]++;
                if (solveNum[1][j%8] == answers[j])  correctNum[1]++;
                if (solveNum[2][j%10] == answers[j])  correctNum[2]++;
            }
        }   //  correctNum = {5,0,0}, {3,4,5}

        int maxScore = Math.max(correctNum[0], Math.max(correctNum[1],correctNum[2]));
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int k=0; k<correctNum.length; k++) {
            if (correctNum[k] == maxScore) {
                list.add(k+1);
            }
        }
        // ArrayList<Integer> -> int[] Array 변환
        // intValue(): Integer 객체에서 int형 값을 뽑아내는 메소드
        return list.stream().mapToInt(i->i.intValue()).toArray();
        
    }
}
