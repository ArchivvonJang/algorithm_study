package moon;
// 1 1 0 => 0번째 노드의 연결 정보
// 1 1 0 => 0번째 노드의 연결 정보
// 0 0 1 => 0번째 노드의 연결 정보

public class DFS_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // 노드이자 1번째 배열의 길이만큼.

        for (int i=0; i< n; i++) {      //  노드 0번째부터 탐색. 연결된 노드들을 계속 탐색해 나감.
            if (!visited[i]) {      // 방문한 노드이면 탐색 X.
                dfs(i, visited, computers);
                answer++;
                for (boolean b : visited) {
                    System.out.print(b + ", ");
                }
                System.out.println();
                // true, true, false, => 연결된 2번째 노드까지 방문 완료
                // true, true, true,  => 3번째 노드까지 방문 완료
            }
        }
        return answer;
    }

    public void dfs (int node, boolean[] visited, int[][] computers) {
        visited[node] = true;
        for (int i=0; i<computers.length; i++) {
            if (node!=i && visited[i] == false && computers[node][i] == 1) {  //  자기자신이 아니고, 방문한 적 없고, 연결된 노드이면
                dfs(i, visited, computers);     // 연결된 노드 탐색
            }
        }
    }

    public static void main(String[] args) {
        DFS_네트워크 k = new DFS_네트워크();
        int answer = k.solution(3, new int[][]{{1,1,0}, {1,1,0}, {0,0,1}});
    }
}
