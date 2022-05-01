package yun;

import java.util.Arrays;

public class 징검다리 {
	public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
		long answer = 0;
		long left = 1;
		long right = distance;
		long mid = 0;
		
		while(left <= right) {
			int remove = 0; //제거하는 돌 갯수
			int prevRock = 0; //이전 바위, 현재 바위와 거리를 구하고 mid 값과 비교
			
			mid = (left + right) / 2;
			
			for(int currentRock : rocks) {
				if(currentRock - prevRock < mid) {//mid보다 작으면 제거 왜냐면 mid는 최소거리 
					remove++;
				}else {
					prevRock = currentRock; //
				}
			}
			
			if(distance - prevRock < mid) remove++;
			
			if(remove <= n) {//제거하는 바위의 갯수가 주어진 n보다 작으면 거리를 늘린다.
				answer = mid > answer ? mid : answer;
				left = mid + 1;
			} else {//n보다 크다면 거리를 줄인다.
				right = mid -1;
			}
		}
		return (int)answer;
    }

	public static void main(String[] args) {
		int distance = 25;
		int[] rocks = {2, 14, 11, 21, 17};
		int n = 2;
		징검다리 a = new 징검다리();
		System.out.println(a.solution(distance, rocks, n));

	}

}
