package moon;
import java.util.Arrays;
// 내 풀이 : sort를 한 뒤 앞에서부터 i는 0부터 j는 i+1부터 시작하도록 이중 반복문을 돌렸다
// 문제 : 최댓값+최솟값을 더해야 가장 최소의 보트를 사용하게 되는 것을 간과했다. => 작은 값+작은 값끼리 계산하여 처리해버리니 뒤에 가능성있는 큰 값을 고려 X
// solved : 최솟값(min)과 가장 큰값(max)끼리 더한게 limit을 넘으면 어짜피 다른 몸무게와도 안될테니 혼자 태운다.
public class Greedy_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 1. 오름차순 정렬을 통해 적은 몸무게값들부터 계산
        Arrays.sort(people);
        int min = 0;
        // 2. min은 앞에서 ++, max는 뒤에서--하며, 두명 혹은 한명이 보트에 탄다.
        for (int max = people.length-1; min<=max; max--) {  // 한 index로 모였다는 것은 하나라도 통과되지 않은 것. min+max가 limit 넘든 안넘든 answer++하니까 상관x
            if (people[max] + people[min] <= limit) min++;  // 두명이 같이 타면 min은 뒤로 한칸 이동해서 비교해야함
            answer++;   // 혼자타든 둘이 타든 보트+=1
        }


        /*for (int i = 0; i< people.length-1; i++) {
            if (safe[i]) continue;
            for (int j=i+1; j< people.length; j++) {
                if (!safe[j] && limit-people[i] >= people[j]) {
                    safe[i] = safe[j] = true;
                    answer++;
                    break;
                }
            }
            if (!safe[i]) {
                safe[i] = true;
                answer++;
            }
        }
        if (!safe[people.length-1]) answer++;*/

        return answer;
    }

    public static void main(String[] args) {
        Greedy_구명보트 t = new Greedy_구명보트();
        System.out.println(t.solution(new int[]{40,50,150,160}, 200));  // 2
        System.out.println(t.solution(new int[]{100,500,500,900,950}, 1000));  // 3
    }
}