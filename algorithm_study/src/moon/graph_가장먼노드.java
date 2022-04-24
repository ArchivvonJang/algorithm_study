package moon;
import java.util.*;

public class graph_가장먼노드 {
    int maxLevel = 0;
    int[] level;
    boolean[] visited;
    List<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        level = new int[n+1];
        for (int i=1; i<=n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        bfs();
        int nodeNum = 0;
        for(int l : level) {
            if (maxLevel == l) nodeNum++;
        }
        return nodeNum;
    }
    void bfs() {
        Queue<Integer> que = new LinkedList<>();
        level[1] = 1;
        que.offer(1);
        visited[1] = true;
        while (!que.isEmpty()) {
            int n = que.poll();
            for(int i=0; i<graph[n].size(); i++) {
                int adj = graph[n].get(i);
                if (!visited[adj]) {
                    level[adj] = level[n]+1;
                    que.offer(adj);
                    visited[adj] = true;
                    maxLevel = Math.max(maxLevel, level[adj]);
                }
            }
        }
    }
    public static void main(String[] args) {
        graph_가장먼노드 t = new graph_가장먼노드();
        t.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }
}
