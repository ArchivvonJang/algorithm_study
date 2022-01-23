package jang;

import java.io.IOException;
import java.util.HashMap;

//해시 완주하지 못한 선수
public class Hash01Marathon {
    public String solution(String[] participant, String[] completion) {

        String answer = "";

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        //참가자들 이름을 player에 담고 value값 부여하기
        for(String player : participant){
            // player라는 key가 존재하면 player를 넣어주고, 없다면 0+1
            // 중복이름이라면 value 가 +1이 될 것
            map.put(player, map.getOrDefault(player,0) + 1);
        }
        for (String player : completion){
            // map의 key을 이용하여 value값 가져오기
            map.put(player, map.get(player)-1); //-> 완주한 선수들의 value == 0
        }

        // key가 되는 이름들 꺼내기
        for (String key : map.keySet()){
            //value가 0이 되지 못한 선수들이름 꺼내기
            if(map.get(key) != 0) answer = key;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        String player[] = {"mislav", "stanko", "mislav", "ana"};
        String completion[] = {"stanko", "ana", "mislav"};

        System.out.println("---> answer : " + new Hash01Marathon().solution(player, completion));
    }
}
