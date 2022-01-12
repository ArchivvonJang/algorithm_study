package jang;

import java.io.IOException;
import java.util.*;

//깊이넓이우선탐색 네트워크
public class DfsBfs02 {
                       //컴퓨터 갯수, 연결확인하는 2차원배열
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n]; //방문했는지 안했는지 확인

        for(int i = 0; i < n; i++){

            if(!visited[i]) { //방문하지않았으면 dfs로
               // bfs(computers, visited, i);
                dfs(computers, visited, i);
                answer++;
            }
        }

        return answer;
    }

    public void bfs(int[][] computers, boolean[] visited, int node){
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        while(!queue.isEmpty()){
            int pop = queue.remove(); //큐에서 꺼낸 값값

           for(int i = 0; i < computers[pop].length; i++){
                int next = -1; //i는 0부터 시작한다. i가 아닌 것을 표시하기 위해 -1을 담는다.

                if(pop != i && computers[pop][i] == 1){ //컴퓨터가 이어져있으면
                    next = i;

                }
                if(next == -1 || visited[next]) continue; //방문한적 없다면 지나가기

                queue.add(next); //다시큐에 담고

                visited[next] = true; // 방문 체크를 해준다.

            }

        }
    }

    public void dfs(int[][] computer, boolean[] visited, int node){
        visited[node] = true;

        for(int i = 0; i < computer[node].length; i++){
            if(visited[i]) //방문했던거라면 지나가기
                continue;
            if(node == i || computer[node][i] != 1) //연결되지 않았다면 지나가기
                continue;

            visited[i] = true;
            dfs(computer, visited, i); //계속 파고들어서 확인하고 visited에 담아준다.
        }

    }

    public static void main(String[] args) throws IOException {
        System.out.println( "return : "
                        + new DfsBfs02().solution(4,
                        new int[][]{{1, 1, 1,0}, {0, 1, 1,0}, {1, 0,1,0},{0,0,0,1}}));


    }

}
