package yun;

import java.util.*;
//        속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//        장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//        장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

public class 베스트앨범 {
	
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String,Integer> totalNumOfPlays = new HashMap<>(); //장르별 재생횟수 합계용 맵
        HashMap<Integer,String> indexForGenres = new HashMap<>(); //장르별 인덱스 번호
        Map<Integer,Integer> indexForPlays = new HashMap<>(); // 재생횟수별 인덱스 번호
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++){
            String key = genres[i];
            int  value = plays[i];
            totalNumOfPlays.put(key,totalNumOfPlays.getOrDefault(key,0)+value); //장르별 재생횟수 합계
            indexForGenres.put(i,key); //
            indexForPlays.put(i,value);
        }
       
       //
	   ArrayList<String> totalList = new ArrayList<>();
	   for(String key : totalNumOfPlays.keySet()) {
		   totalList.add(key);
	   }
	   Collections.sort(totalList, (o1, o2) -> totalNumOfPlays.get(o2) - totalNumOfPlays.get(o1));
        
	   List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(indexForPlays.entrySet());
	   entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
		   @Override
           public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
			   return o2.getValue() - o1.getValue();
           }
        });
        
        for(String tList : totalList){
            int k = 0;
            for(Map.Entry<Integer,Integer> entry : entryList){
                if(k == 2) break;
                if(tList.equals(indexForGenres.get(entry.getKey()))){
                    result.add(entry.getKey());
                    k ++;
                }
            }
        }
        
        answer = new int[result.size()];
        
        for(int i = 0; i < answer.length ; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		베스트앨범 sol = new 베스트앨범();
		System.out.println(Arrays.toString(sol.solution(
				new String[] {"classic", "pop", "classic", "classic", "pop"},
				new int[] {500, 600, 150, 800, 2500})
				));

	}

}
