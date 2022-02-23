package moon;

import java.util.PriorityQueue;

public class 힙_더맵게2 {
    int answer = 0;
    int smallestS;
    int secSmallestS;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        for (int s : scoville)
            addScoville(s);

        // 1개 이상 남고 K보다 작은 값만 나올 때
        while (pq.size()> 1 && pq.peek() < K) {
            calScoville();
        }
        if(isImpossible(K))
            return -1;
        return answer;
    }

    private boolean isImpossible(int K) {
        if (pq.size()==1 && pq.poll() < K)
            return true;
        return false;
    }
    private void calScoville() {
        smallestS = pq.poll();
        secSmallestS = pq.poll();
        addScoville(smallestS + (secSmallestS * 2));
        answer++;
    }
    private void addScoville(Integer s) {
        pq.add(s);
    }

    public static void main(String[] args) {
        int[] scoville = new int[]{1,2,3,9,10,12};
        힙_더맵게2 k = new 힙_더맵게2();
        int ret = k.solution(scoville, 7);
        System.out.println(ret);
        System.out.println("출력");
    }
}