package jang;

import java.util.HashSet;

//동적계획법 - N으로 표현
// i개의 N으로 표현 가능한 수들을 찾고 number가 그 안에 포함되어있는 지를 확인한다.
public class DynamicProgramming01N {
    private int answer;
    private int origin;
    HashSet<Integer>[] set; //set[n] = N을 n번 사용하여 만들 수 있는 숫자들의 집합. ( 중복은 허용햐지 않는다. )

    public int solution(int N, int number) {
        answer = 0;
        origin = N;
        set = new HashSet[9]; // 1 이상 9 이하의 N을 사용하도록 배열 크기를 지정해준다.

        for(int i=1; i<=8; i++) {
            getNum(i);

            if(set[i].contains(number)){
                return i;
            }
        }

        return -1; // 최솟값이 8보다 크면 -1을 반환한다.
    }

    public HashSet<Integer> getNum(int n){

        if(set[n]!=null) return set[n]; //이미 값이 있으면 그대로 반환한다.

        int num = 0;

        // N이 i개, N을 이용하여 1개인 경우 N, 2개인 경우 NN, 3개인 경우 NNN ... 숫자를 만들어서 넣는다.
        for (int i = 0; i < n; i++) {
            num = 10 * num + origin;
        }

        // 초기화하고 num을 담는다.
        set[n] = new HashSet<>();
        set[n].add(num);

        //모든 경우의 수를 구한다.
        for (int i = 0; i < n; i++) {
            int j = n - i;

            if( set[i] != null || set[j] != null){
                getNum(i);
                getNum(j);
            }
            for(int n1 : set[i]) {
                for(int n2 : set[j]) {
                    set[n].add(n1+n2);
                    set[n].add(n1-n2);
                    set[n].add(n1*n2);
                    if(n2!=0) set[n].add(n1/n2);
                }
            }
        }

        return set[n]; //n의 사용 횟수를 담아서 반환한다.
    }

    public static void main(String[] args) {
        int N = 2;
        int number = 11;

        DynamicProgramming01N dpn = new DynamicProgramming01N();

        System.out.println(dpn.solution(N, number));
    }
}
