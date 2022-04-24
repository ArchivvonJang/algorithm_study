package jang;

import java.util.Arrays;

public class BinarySearch02징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        long answer = 0; //거리의 최소값

        //바위를 오름차순 정렬
        Arrays.sort(rocks);

        long left = 1; //가장 최소값
        long right = distance; //최대값
        long mid = 0; //중간값 == 거리의 최소값

        while(left <= right){
            mid= (left + right) / 2;
            //바위 사이의 최소값이 mid일 때 제거할 바위의 개수
            int remove = 0;
            //이전 바위부터 계산하는 바위(check)까지의 거리를 구하고 mid와 비교
            int rock = 0;

            for(int check : rocks){
                //현재 확인하는 돌에서 이전의 돌 사이의 거리를 구했을 때, 기준이 되는 mid보다 작은 경우에는 제거한다.
                if(check - rock < mid) remove++;
                //같은 경우라면, 다시 조건에 맞지 않는 대상이 있는지 찾아야하므로 이전 돌의 값을 현재 확인하는 돌로 변경한다.
                else rock = check;
                //이 과정을 반복하고 나면 처음 돌부터 마지막 돌까지 나열되어있을 때, 모든 돌 사이의 거리가 mid 이상이 된다.
            }

            //여기서부터는 남아있는 돌과 distance의 거리를 확인한다.
            //마지막 돌에서 이전 돌의 거리가 최소값보다 작으면 제거한다.
            if(distance - rock < mid) remove++;

            //제거된 돌의 수(remove)가 n보다 작아야한다.
            //mid 중에서 가장 최대값을 구한다.
            if(remove <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;

            }else right = mid - 1;

        }

        return (int)answer;
    }
}
