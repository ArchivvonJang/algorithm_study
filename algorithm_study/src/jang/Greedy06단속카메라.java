package jang;

import java.util.Arrays;

public class Greedy06단속카메라 {
    public int solution(int[][] routes) {

        //1. 차량 진입지점 오름차순 졍렬
        Arrays.sort(routes, (a, b) -> (a[1] - b[1]));

        int answer = 1; //처음 설치된 카매라 갯수
        int cam = routes[0][1]; //처음 카메라 설치 지점

        //2. 차량 갯수만큼 반복한다.
        for(int i = 0; i < routes.length; i++){
            //3. 카메라 설치 지점이 차량 진입지점보다 뒤에 있다면 카메라 설치가 가능하다.
            if(cam < routes[i][0]){
                //4.차량 진출지점은 카메라 설치 위치가 된다.
                cam = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
