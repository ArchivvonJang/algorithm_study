package yun;

import java.util.Arrays;

public class 체육복 {
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<reserve.length; i++) {
        	for(int j=0; j<lost.length; j++) {
        		if(reserve[i] == lost[j]) {
        			answer++;
        			reserve[i] = -1;
        			lost[j] = -1;
        		}
        	}
        }
        
        for(int i=0; i<reserve.length; i++) {
        	for(int j=0; j<lost.length; j++) {
        		if(reserve[i] != -1 && lost[j] != -1) {
        			if(reserve[i] - lost[j] == 1 || reserve[i] - lost[j] == -1) {
        				answer++;
        				reserve[i] = -1;
        				lost[j] = -1;
        			}
        		}
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
//		System.out.println(solution(5, new int[] {2,4}, new int[] {1,3,5}));
//		System.out.println(solution(5, new int[] {2,4}, new int[] {3}));
		System.out.println(solution(3, new int[] {3}, new int[] {1}));

	}

}
