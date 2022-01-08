package jang;

import java.io.IOException;

public class DfsBfs01 {
    // 깊이/넓이 우선탐색 (DFS/BFS) - 타겟넘버

    // 생각하기
    // numbers 배열과 target 숫자가 주어지면 target이 되는 number의 조합 갯수를 return
    // 적절히 더하거나 빼는 로직을 짜야한다.
    // 로직을 컬렉션에 담고 size를 꺼내주면 끝
    // dfs - stack/ bfs-queue
    // 풀이

    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
                // 숫자배열, depth, 숫자배열로 만든 sum, 목표 값
        return answer;
    }
    private int dfs(int[] numbers, int depth, int sum, int target){
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

        // 뺄셈과 덧셈을 적용하며, dfs 호출
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
