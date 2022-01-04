package moon;

import java.util.HashSet;
import java.util.Set;

// 소수
// 모든 수의 경우의 수 => dfs 이용
// char[]를 int로 바꿔야함 => charArrToInt 메서드
// 중복 제거 필요 => Set 이용

public class 완전탐색_소수찾기 {
    StringBuilder testSB = new StringBuilder(); // 테스트SB
    static StringBuilder sb = new StringBuilder();         // StringBuilder가 지역 내에 있을 때 n개이상 생성이 되기 때문에 지역 내에 생성하기보다 전역으로 둬서 매번 비우는게 좋음.

    boolean[] visited;  // 방문 체크
    char[]  charArr;    // 반복문을 돌면서 문자 수를 완성시켜나갈 배열
    Set<Integer> returnSet = new HashSet<>();   // 중복제거 리턴 셋

    // 소수(2 이상이면서 자기 자신 외에 나누어 떨어지지 않는 수) 인지 확인
    public boolean isPrime(int p) {
        if (p == 1 || p == 0) return false;
        for (int i=2; i<p; i++) {   // p가 2인 경우,  2<2이므로 자동 i++
            if (p%i == 0) return false; // p가 어떤 수로 잘 나눠떨어지면 소수 x
        }
        return true;
    }

    // char[]을 length 길이만큼 잘라서 int형으로 변환(parseInt) 후 반환
    public int charArrToInt(char[] charArr, int length) {
        //StringBuilder sb = new StringBuilder();// String에 붙여야하니
        sb.setLength(0); // 전역에 StringBuilder를 생성하고 매번 사용 시에 sb를 초기화하는 것을 추천.
        for (int i=0; i<length; i++) {
            sb.append(charArr[i]);
        }
        return Integer.parseInt(new String(sb));
    }

    // dsf(깊이탐색)
    public void dfs(int level, int length, String numbers) {
        if (level == length) {  // length 자리수까지 모두 charArr에 들어왔으면 set에 추가
            int intNum = charArrToInt(charArr, length);
            testSB.append(intNum + " -> ");
            if (isPrime(intNum)) returnSet.add(intNum);
        }
        else {  // level이 length만큼 들어오도록 length번 반복문 실행해서 자릿수를 매칭    <- 이걸 각 숫자(numbers.length)마다 실행 (아래 가장 첫번째 for문에 의해)
            for (int charIdx =0; charIdx < numbers.length(); charIdx++) {  // 1번째 반복문: arr[0] -> 이때 2번째자릿수 arr[1]를 정하는 반복문 => 모든 arr[0]에 해당하는 arr[1]을 반복문 돌면서 매칭
                if(!visited[charIdx]) {
                    visited[charIdx] = true;
                    charArr[level] = numbers.charAt(charIdx);   // dfs(0,1,numbers): charArr[0]=3으로 이미 visited[3]이 true니까 visited[3]에는 방문 x ex) 33, 00, 11, 44..
                    dfs(level+1, length, numbers);
                    visited[charIdx] = false;   // Q. 33,22와 같이 같은 수의값은 소수가 아니므로 이를 사전에 차단하기위해 쓰이는 용도 only?
                }
            }
        }
    }
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        charArr = new char[numbers.length()];

        for (int length=1; length<=numbers.length(); length++) { //  자릿수 길이이자 깊이 정도를 하나씩 늘리면서 매칭시킴
            dfs(0, length, numbers);
        }
        // length가 1이면
           // dfs(0,1,numbers) -> dfs(1,1,numbers) -> 1자리 수 set에 추가
        // length가 2이면
           // dfs(0,2,numbers) -> dfs(1,2,numbers) -> dfs(2,2,numbers) -> 2자리 수 set에 추가   <- 이걸 각 숫자(numbers.length)마다 실행
        // length가 3이면
            // dfs(0,3,numbers) -> dfs(1,3,numbers) -> dfs(2,3,numbers) ->  dfs(3,3,numbers) -> 3자리수 set에 추가set에 추가
        // length가 5면
            //dfs(0,5,numbers) -> ... -> dfs(5,5numbers) -> 5자리 수 set에 추가
        System.out.println(testSB);
        System.out.println(returnSet.toString());
        return returnSet.size();
    }

    public static void main(String[] args) {
        완전탐색_소수찾기 k = new 완전탐색_소수찾기();
        k.solution("301427");
    }
}
