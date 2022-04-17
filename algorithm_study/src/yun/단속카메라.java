package yun;

import java.util.Arrays;

public class 단속카메라 {
	public int solution(int[][] routes) {
		/*
		 * 나간 지점을 기준으로 오름차순 정렬
		 * 차량들이 겹치는지 알기 위해서
		 * */
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
                
		int answer = 0;
		int min = Integer.MIN_VALUE;
		
		for(int[] route : routes) {
			if(min < route[0]) {
				/*
				 * min이 다음 차량의 시작점보다 작으면
				 * 현재 차량과 다음 차량이 겹치는 경우가 없다
				 * 그래서 현재 차량이 나갈때 카메라에 찍혀야함
				 */
				min = route[1];
				answer++;
			}
			/*
			 * min이 다음 차량의 시작점보다 크면
			 * 다음 차량은 현재 차량의 주행이 끝나기전에 출발했다 = 겹친다
			 * 현재 차량의 나가는 지점에서 다음 차량도 카메라에 같이 찍혔다.
			 * 그래서 카메라 설치 필요 없음.
			 * */
		}
        
        return answer;
    }

	public static void main(String[] args) {
		단속카메라 a = new 단속카메라();
		System.out.println(a.solution(new int[][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
	}

}
