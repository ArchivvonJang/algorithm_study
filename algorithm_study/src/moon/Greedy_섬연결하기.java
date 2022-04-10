package moon;
import java.util.Arrays;

// 크루스칼 알고리즘 : 가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘
// 1. 오름차순으로 정렬한다.
// 2. 적은 수(가중치)부터 노드를 연결해가는데, 이미 연결된 노드인 경우 pass한다. -> 최소 비용으로 먼저 연결
// Union-Find : 합집합 찾기
// 두 정점이 연결되어있는가?
// 기준 : 최상위 부모가 같으면 연결되어 있는 것.
// 현 문제에서의 부모의 기준 : 더 적은 수
// 문제: 모든 섬을 연결하는 가장 적은 비용
// 1. 비용을 기준으로 오름차순 정렬
// 2. 적은 비용인 섬들끼리 연결한다.
public class Greedy_섬연결하기 {
    public int solution(int n, int[][] costs) {
        // 0. 초기화
        int[] parent = new int[n];  // 최상위 부모노드를 기억하는 배열
        for (int i=0; i<n; i++) parent[i] = i;  // 초기는 연결된 노드가 없으니, 자기 자신을 부모로 세팅
        int answer = 0;
        // 1. 오름차순 정렬 (costs의 3번째 idx로 정렬)
        Arrays.sort(costs, (c1, c2)-> {
            return c1[2]-c2[2];
        });

        // 2. costs의 노드를 방문하며 노드 연결 (기준은 Union)
        for (int i=0; i<costs.length; i++) {
            // 노드 세팅
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            // 연결 되어있는가?
            if (isConnected(from, to, parent)) continue;
            else { // 연결되어있지 않다면 최상위 부모 노드 기준 연결
                answer+=cost;   // 연결 비용(가중치) 추가
                connectNode(from, to, parent);
            }
        }
        return answer;
    }

    // 노드를 연결할 때는 최상위 부모와 연결한다.
    private void connectNode(int from, int to, int[] parent) {
        int fromsParent = getParent(from, parent);
        int tosParent = getParent(to, parent);
        if (fromsParent < tosParent) parent[tosParent] = fromsParent;
        else parent[fromsParent] = tosParent;
    }

    private boolean isConnected(int from, int to, int[] parent) {
        // 최상위 부모가 같은지 체크
        int fromsParent = getParent(from, parent);
        int tosParent = getParent(to, parent);
        return fromsParent == tosParent;
    }

    private int getParent(int node, int[] parent) {
        if (parent[node] == node)   return node;    // 부모가 자기 자신일 경우, 자기 자신을 리턴
        return getParent(parent[node], parent);    // 자기 자신이 아닌 경우, 최상위 노드까지 탐색해서 반환해야함
    }

    public static void main(String[] args) {
        Greedy_섬연결하기 t = new Greedy_섬연결하기();
        int solution = t.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
        System.out.println(solution);
    }
}