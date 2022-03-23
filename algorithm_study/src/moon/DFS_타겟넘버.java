package moon;
// 주어지는 숫자(0,양수)를 +,-해서 target이 되는 경우의 수
class DFS_타겟넘버 {
    int answer=0;
    public int solution(int[] numbers, int target) {
        // 1. answer은 전역변수로 선언
        // 2. dfs 수행
        dfs(numbers,target,0,0);
        return this.answer;
    }
    // 3. dfs(numbers, target, depth:깊이이자 배열 idx, sum: 현재 누적 값)
    public void dfs(int[] numbers,int target,int depth,int sum){
        // 4. 모든 정수를 탐색했을 때,
        if(depth == numbers.length){
            // 5. 누적합이 target과 동일하면 answer++ 후 메소드 종료.
            if(sum == target) answer++;
            return;
        }
        // 4. +인 경우, -인 값으로 각각 다시 재귀호출 (depth+1)
        int add= sum + numbers[depth];
        int sub = sum - numbers[depth];
        // 6. 다음 인덱스 dfs 수행
        dfs(numbers,target,depth+1,add);
        // 6. 다시 다음 인덱스 dfs 수행
        dfs(numbers,target,depth+1,sub);
    }
}
/** 이해를 위해..
 * 4+1 + 2+1 => 8 != 4
 * 4+1+2 -1 => 6 !=4
 *
 * 4+1-2+1=> 4 == 4  -> cnt++
 * 4+1-2-1=> 2 != 4
 * 4-1 +2+1 => 6 != 4
 * 4-1 +2-1 =>4 == 4   -> cnt++
 * 4-1-2+1 => 2!=4
 * 4-1-2-1 => 0!=4
 *
 * -4+1+2+1 => 0
 * -4+1+2-1 => -2
 * -4+1-2 +1 =>-4
 * -4+1-2-1 =>-6
 *
 * -4-1+2+1 =>-3 !=4
 * -4-1+2-1 => -5 !=4
 * -4-1-2+1 => -6
 * -4-1-2-1 => -8
 *
 * - 깊이 0 add,sub계산
 *   - 깊이 1, add값으로 dfs 호출
 *     깊이 1 add sub 계산
 *     - 깊이 2, add값으로 dfs 호출
 *       깊이 2 add sub 계산
 *         -깊이 3, add값으로 dfs 호출
 *         깊이 3 add sub 계산
 *          깊이 4, add값으로 dfs 호출
 *          깊이 4, target 일치 검사 후 함수 종료.
 *
 *          깊이 4, sub값으로 dfs 호출
 *          깊이 4, target 일치 검사 후 함수 종료.
 *
 *         -깊이 3, sub값으로 dfs 호출
 *           깊이 4 add sub 계산
 *           깊이 4, add값으로 dfs 호출
 *           깊이 4, target 일치 검사 후 함수 종료.
 *
 *           깊이 4, sub값으로 dfs 호출
 *           깊이 4, target 일치 검사 후 함수 종료.
 *     - 깊이 2, sub값으로 dfs 호출
 *     - ...위와 같이 add, sub 계산 후 add으로 먼저 dfs 호출하고, sub으로 dfs 호출
 */