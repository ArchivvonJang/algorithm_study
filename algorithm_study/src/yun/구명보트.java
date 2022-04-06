package yun;

import java.util.Arrays;

public class 구명보트 {
	public static int solution(int[] people, int limit) {
        int answer = 0;
        int min = 0;
        
        Arrays.sort(people);    
        //      50, 50, 70, 80
        //1 -> min         max -> 100이상 -> max--(80만 건너감)
        //2 ->     min max     -> 100이상 -> max--(70만 건너감)
        //3 -> min max         -> 100이하
        
        for(int max = people.length - 1; min <= max; max--) {
        	if(people[min] + people[max] <= limit) {
        		min++;
        	}
        	answer++;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {70,50,80,50}, 100));
	}

}
