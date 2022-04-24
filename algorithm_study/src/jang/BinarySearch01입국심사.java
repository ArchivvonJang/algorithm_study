package jang;

import java.util.Arrays;

public class BinarySearch01입국심사 {
    public long solution(int n, int[] times) {
        //이분(진) 탐색을 위해 배열 정렬
        Arrays.sort(times);
        //최소 범위(왼쪽) 1(시간1)*1(사람1) = 1
        long min = 1;
        //최대 범위(오른쪽) 시간 제일 오래 걸리는 심사대, n명이 심사 받는 경우
        long max = (long) times[times.length-1]*n;
        //각 심사대에서 mid 시간동안 처리할 수 있는 사람 수
        long mid = 0;
        //심사받는데 주어진 시간
        long sum;
        long answer = max;

        while(min <= max) {
            sum = 0;
            mid = (min + max) / 2;
            //심사대에서 주어진 시간동안 몇 명 검사할 수 있는지 누적한다.
            for(int time : times) {
                sum += mid / time;
            }
            //입국기다리는 사람보다 더 많은 사람을 심사 처리 한 경우, 시간 여유
            //시간을 줄여서 가장 최적의 경우의 수(시간)을 구한다.
            if(sum >= n) {
                answer = mid;
                max = mid - 1;
            }
            else {  //입국기다리는 사람이 남아있으므로 시간부족,시간이 더 필요하다.
                min = mid + 1;
            }
        }
        return answer;
    }
}
