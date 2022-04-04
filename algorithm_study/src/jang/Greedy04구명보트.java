package jang;

import java.util.Arrays;

public class Greedy04구명보트 {
    static int solution(int[] people, int limit) {
        int answer = 0;

        //오름차순으로 정렬
        Arrays.sort(people);

        //50, 50, 70, 80

        int min = 0; //최소값, 배열의 첫번째 사람
        int max = people.length - 1; //최대값, 배열의 마지막 사람

        //가장 몸무게가 무거운 사람 + 가장 몸무게가 가벼운 사람 -> 최소한의 횟수로 옮기기 가능
        //min+max > limit 이면 혼자 보트를 타게 되고, <limit이면 둘이 탈 수 있다.
        //min+max > limit이면 max먼저 태워보내서 max--를 해준다.

        //마지막 사람은 최소값과 더한 값이 제한무게보다 무거운지 가벼운지와 상관없이
        //항상 먼저 탑승하기 때문에 마지막 사람의 인덱스는 하나가 감소된다.
        for ( ;min<=max; max--) {
            if((people[min] + people[max]) <= limit) {

                //limit가 초과하지 않으면 둘이 탈 수 있으므로 min++
                min++;
            }

            answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));


    }
}
