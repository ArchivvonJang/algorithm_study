package jang;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph01가장먼노드 {
    static int solution(int n, int[][] edge) {
        int answer = 0;
        //노드들을 체크했는지 확인해 줄 boolean배열
        boolean visit[] = new boolean[n+1];
        //노드 연결점을 알려줄 boolean 2차원배열
        boolean connect[][] = new boolean[n+1][n+1];

        for (int i = 0; i < edge.length; i++) {
            connect[edge[i][0]][edge[i][1]] = true;
            connect[edge[i][1]][edge[i][0]] = true;
        }
        //인접행렬
        /* 1 2 3 4 5 6
         *1 0 1 1 0 0 0
         *2 1 0 1 1 1 0
         *3 1 1 0 1 0 1
         *4 0 1 1 0 0 0
         *5 0 1 0 0 0 0
         *6 0 0 1 0 0 0
         */

        //BFS
        Queue<Integer> que = new LinkedList<>();
        //연결된 노드들을 담아줄 ArrayList
        List<Integer> nextNodes = new ArrayList<>();

        //시작 노드인 1을 큐에 담는다.
        que.add(1);

        visit[0]= true; //사용하지 않는 0번째 인덱스를 true로 변경
        visit[1] = true; //시작하는 1번 노드를 true로 변경

        //모두 방문(노드 6까지 6번)할 때까지 반복한다.
        while(true){
            //nextNodes가 비어있는 경우, que에 남아있는 노드들이 1번으로부터 가장 멀리 떨어진 노드들, 노드 갯수를 담는다.
            answer = que.size();

            while(!que.isEmpty()){
                int node = que.poll();

                for(int i = 1; i <= n; i++ ){
                    //i번째 노드를 방문했는지, node랑 연결된 노드가 true인지 확인한다.
                    //node가 1인 경우, connect[1][1] 은 연결되어있지 않으므로 false
                    if(!visit[i] && connect[node][i]){
                        //i번 노드가 node와 연결되어 있으므로, nextNodes에 i를 추가해준다.
                        nextNodes.add(i);
                        //방문했으므로 true로 변경한다.
                        visit[i] = true;
                    }
                }
            }
            //nextNodes가 비어있다면 더 이상 연결된 노드들이 없는 경우이므로 멈춘다.
            if(nextNodes.isEmpty()) break;
            //nextNodes에 있는 값들을 전부 que에 담는다.
            que.addAll(nextNodes);
            //que에 모두 부어놓고 다시 사용하기 위해 clear해준다.
            nextNodes.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3},{3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, vertex));
    }
}

