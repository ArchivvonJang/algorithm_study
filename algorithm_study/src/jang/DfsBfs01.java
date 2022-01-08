package jang;

import java.io.IOException;

public class DfsBfs01 {
    // 깊이/넓이 우선탐색 (DFS/BFS) - 타겟넘버

    // 생각하기
    // numbers 배열과 target 숫자가 주어지면 target이 되는 number의 조합 갯수를 return
    // 적절히 더하거나 빼는 로직을 짜야한다.
    // 로직을 컬렉션에 담고 size를 꺼내주면 끝
    // dfs - stack/ bfs-queue

    // dfs로 해결, bfs도 해보기 !

    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
                // 숫자배열, depth, 숫자배열로 만든 sum, 목표 값
        return answer;
    }

    //배열의 모든 요소를 더하거나 빼서 target 넘버를 만드는 방법의 수를 return하는 메소드
    private int dfs(int[] numbers, int depth, int sum, int target){
        //numbers의 크기와 depth가 일치하는 경우 -> 모든 자리에 대한 탐색 완료
        if(depth == numbers.length){
            if(sum==target)
                return 1;
            return 0;
        }
        //확인
        System.out.println("depth : " + depth + " ,  sum : " + sum + " , next depth : " + (depth + 1) + " , numbers[depth] : " + numbers[depth]
                                + " , sum+numbers[depth] : " + (sum+numbers[depth])
                                +  " , sum-numbers[depth] : " + (sum-numbers[depth]) );
        /*
        depth = node 노드를 순서대로 방문한다. 다시 4와 인접한 노드 3 -> 4 -> 3 방문했으니 2 이런식으로 모든 노드를 돈다 ?
        depth : 0 ,  sum : 0 , next depth : 1 , numbers[depth] : 1 , sum+numbers[depth] : 1 , sum-numbers[depth] : -1
        depth : 1 ,  sum : 1 , next depth : 2 , numbers[depth] : 1 , sum+numbers[depth] : 2 , sum-numbers[depth] : 0
        depth : 2 ,  sum : 2 , next depth : 3 , numbers[depth] : 1 , sum+numbers[depth] : 3 , sum-numbers[depth] : 1
        depth : 3 ,  sum : 3 , next depth : 4 , numbers[depth] : 1 , sum+numbers[depth] : 4 , sum-numbers[depth] : 2
        depth : 4 ,  sum : 4 , next depth : 5 , numbers[depth] : 1 , sum+numbers[depth] : 5 , sum-numbers[depth] : 3
        depth : 4 ,  sum : 2 , next depth : 5 , numbers[depth] : 1 , sum+numbers[depth] : 3 , sum-numbers[depth] : 1
        depth : 3 ,  sum : 1 , next depth : 4 , numbers[depth] : 1 , sum+numbers[depth] : 2 , sum-numbers[depth] : 0
        depth : 4 ,  sum : 2 , next depth : 5 , numbers[depth] : 1 , sum+numbers[depth] : 3 , sum-numbers[depth] : 1
        depth : 4 ,  sum : 0 , next depth : 5 , numbers[depth] : 1 , sum+numbers[depth] : 1 , sum-numbers[depth] : -1
        depth : 2 ,  sum : 0 , next depth : 3 , numbers[depth] : 1 , sum+numbers[depth] : 1 , sum-numbers[depth] : -1
         */

        // 더하거나 빼는 연산과정을 Tree로 보고 '+'연산은 왼쪽 자식노드, '-'연산은 오른쪽 자식 노드로 내려가는 과정으로 재귀호출을 통해 해결한다
        return dfs(numbers, depth+1, sum + numbers[depth], target)
                + dfs(numbers, depth+1, sum - numbers[depth], target);

    }
    //값 확인하기 위해
    public static void main(String[] args) throws IOException {
        int target = 3;
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 1;
        }

        System.out.println("answer : " +  new DfsBfs01().solution(numbers, target) );

    }

}
