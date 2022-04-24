package yun;

import java.util.Arrays;

public class 입국심사 {
	/*
	 * mid가 주어질때, 심사관 당 맡을 수 있는 입국자 수를 계산한다
	 * 심사관 당 맡을 수 있는 입국자 수 = 추정시간 값 / 심사관 당 심사시간
	 * 모든 사람이 심사를 받는데 걸리는 시간이 mid면, mid 당 심사위원들의 심사인원 수가 
	 * n보다 크면 시간을 줄이고, 작다면 시간을 늘린다.
	 * 
	 * */
	public long solution(int n, int[] times) {
        Arrays.sort(times);
        
		long answer = 0;
		long left = 1;//최선
		long right = (long) n * times[times.length - 1]; //최악 
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;//총 심사한 인원 
			for(int time : times) {
				sum += mid / time;
			}
			if(sum < n) { // 해야할 인원보다 심사 못 함 -> 시간 더 필요
				left = mid + 1;
			} else {//해야할 인원보다 많이 처리 -> 시간 줄임
				right = mid -1;
				answer = mid;
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 6;
		int[] times = {7,10};
		입국심사 a = new 입국심사();
		System.out.println(a.solution(n, times));

	}

}
