package jang;
// 깊이넓이우선탐색 - 여행경로

import java.io.IOException;
import java.util.*;

public class DfsBfs04 {
    //[a,b] : a -> b
    // 가능한 경로가 2개 이상이면 알파벳 순서대로
    // 모든 도시 방문

    //필요한 변수 선언
    boolean[] visited; // 방문한 여행 경로인가 확인
    ArrayList<String> route; //sort()의 매개변수 타입은 List<T>로 제네릭을 받는다. T는 Comparable 인터페이스를 구현해야만 한다.
    public String[] solution(String[][] tickets) {

        String[] answer = {};
        int cnt=0;
        visited = new boolean[tickets.length];
        route = new ArrayList<>();

        //항상 시작은 ICN부터
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(route); //Sorts the specified list into ascending order, according to the natural ordering of its elements, Timsort
        answer = route.get(0).split("/");

        return answer;
    }

    //넓이우선탐색
    public void dfs(String arrive, String depart, String[][] tickets, int cnt){

        if(cnt == tickets.length){
            System.out.println("--------------------------------------------");
            route.add(depart);
            return;
        }
        for (int i = 0; i < tickets.length; i++){
            if(arrive.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;

                System.out.println("cnt : " + cnt +", arrive : "+arrive +", 확인 : "+ i +", depart & ticket i : "+ depart+"/"+tickets[i][1]);

               // dfs(tickets[i][1], tickets[i][1], tickets,cnt+1);
                dfs(tickets[i][1], depart+"/"+tickets[i][1], tickets,cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String tickets[][] = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        System.out.println("answer : " + new DfsBfs04().solution(tickets));
    }
}
