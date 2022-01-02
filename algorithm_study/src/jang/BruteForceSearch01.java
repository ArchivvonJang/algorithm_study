package jang;

import java.util.HashSet;
import java.util.Set;

public class BruteForceSearch01 {
// 완전탐색 - 소수찾기
    // 문제
    // 1. 한 자리 숫자가 적힌 종이
    // 2. 종이 조각으로 만들 수 있는 소수 갯수

    // 풀이
    // 1. 모든 순열(Permutation) 구하기 (1~n 개의 모든 길이, 모든 조합)
    // 2. 구한 문자가 소수인지 확인하기 (소수인지는 나누기로 확인)
    // 3. 소수라면 SET에 저장 ( SET : 중복 x, 12 = 012)

    // 반환할 변수
    int answer = 0;
    // 종이 조각을 담을 배열
    char[] arr;
    //탐색하면서 숫자 사용 중복을 막기
    boolean[] visited;
    // 모든 순열을 담을 SET
    Set<Integer> set = new HashSet<Integer>();

    // arr 배열에서 char 종이조각을 꺼내서, 길이 len 만큼 자르고, int로 변환
    public int charToInt(char[] arr, int len){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++){
            sb.append(arr[i]);
        }

        return Integer.parseInt(sb.toString());
    }
    // 모든 순열 구하기 - (순열을 만들 배열, len(number.length)개 중에서 r개를 꺼내는 경우)
    public void per(int depth, int len, String numbers){
    //완전 탐색 - 깊이탐색
    //배열의 첫 값부터 순서대로 하나씩 바꾸며 모든 값을 swap

        if(depth == len){ // depth를 기준인덱스로 잡고, depth보다 작은 값들은 고정, depth보다 큰 값들로 swap 진행하기
            int num = charToInt(arr, len); // int로 변환하고
            if(isPrimeNum(num)) // 소수인지 확인하고
                set.add(num); // set에 담기
        }else{
            for( int i = 0; i<numbers.length(); i++){
                //방문한적 없다면!
                if(!visited[i]){
                    // 이미 add 된 값은 true로 변경해 중복을 방지한다
                    visited[i] = true;

                    arr[depth] = numbers.charAt(i);
                    // 다음 깊이 확인하기
                    per(depth+1, len, numbers);
                    visited[i] = false;
                }// end if visit
            }// end for
        }// end if else
    }//end per


    // 소수(Prime)인지 구하기
    static boolean isPrimeNum(int num){

        //이미 소수라면 끝!
        if(num == 1 || num == 0)
            return false;

        // 2이상 숫자들 소수인지 확인하기
        // Math.sqrt() : 제곱근(루트)구하는 메소드 (원리 이해하기 - https://cjlee38.github.io/btb/ways_to_find_prime_number)
       //for(int i = 2; i < n; i++){
        for (int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }

    // 반환
    public int solution(String numbers) {

        visited = new boolean[numbers.length()];
        arr = new char[numbers.length()];

        for (int i = 1; i<= numbers.length(); i++){
            per(0, i, numbers);
        }
        answer = set.size();

        return answer;
    }

    public static void main(String[] args) {

        String numbers = "1234567809";

        BruteForceSearch01 bfs01 = new BruteForceSearch01();

        System.out.println(bfs01.solution(numbers));

    }

}
