package jang;

import java.util.*;
import java.util.HashMap;
// 해시 - 베스트 앨범
class Song implements  Comparable<Song>{
    int index;
    int count;

    public Song(int index, int count){
        this.index = index;
        this.count = count;
    }
    //재생된 노래 비교하기
    public int compareTo(Song other){
        // 재생 횟수가 같다면, 고유번호 오름차순 정렬해주기
        if(this.count == other.count)
            return Integer.compare(this.index, other.index);

        return Integer.compare(other.count, this.count);
    }

}
public class Hash04BestAlbum {
    // answer 배열에 출력될 순서
    // 속한 노래가 많이 재생된 장르 먼저
    // 장르 내에서 많이 재생된 노래 먼저
    // 장르 내에서 재생 횟수가 같은 노래는 고유번호가 낮은 번호 먼저

    public int[] solution(String[] genres, int[] plays) {

        int[] answer = {};

        List<Integer> result = new ArrayList<Integer>();
        //장르, 재생횟수
        HashMap<String, Integer> genreMap = new HashMap<>();
        //장르, 장르에 속한 노래
        HashMap<String, ArrayList<Song>> playGenreMap = new HashMap<>();

        for(int i =0; i<genres.length; i++) {

            String genre = genres[i]; // 장르
            int play = plays[i]; //재생 횟수

            // <장르, 재생횟수 > Map에 담아준다.
            //genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0)+plays[i]);
            // 이미 장르가 존재하면 2번째 매개변수로 적은 기본값으로 설정한다.
            // 기본값에 play 의 값을 더해준다.
            genreMap.put(genre, genreMap.getOrDefault(genre,0) + play);

            // 장르별 노래 등록
            // computeIfAbsent : 해당 값이 키값으로 없는 경우 두번째 인자로 준 함수를 실행하여 기본값으로 설정한다.
            //                                           새로운 ArrayList를 만들어서 새로운 노래를 추가해준다.
            playGenreMap.computeIfAbsent(genre, s -> new ArrayList<>() ).add(new Song(i, play)) ;

        }

        // 재생 횟수를 내림차순으로 정렬한다.
        List<String> keyList = new ArrayList<>(genreMap.keySet());

        keyList.sort((o1, o2) -> (genreMap.get(o2).compareTo(genreMap.get(o1))));

        //정렬된 장르를 돌면서
        for(String key : keyList){
            // 장르에 속한 노래 목록
            ArrayList<Song> tracks = playGenreMap.get(key);
            // 재생 횟수를 정렬한다. 정렬 횟수가 같으면 고유번호 (인덱스 순으로 정렬)
            Collections.sort(tracks);

            int idx = 0;
            for(Song song : tracks){
                if(idx > 1) break;
                result.add(song.index);
                idx++;
            }
        }

        // ArrayList에 담긴 앨범을 int배열로 옮긴다.
        // 앨범이 담긴 result 크기만큼 초기화
        answer = new int[result.size()];
        int index = 0;

        // 앨범(노래 목록)을 돌면서 배열에 담아준다.
        for(Integer i : result){
            answer[index] = i;
            index++;
        }
        return answer;

    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int [] plays = {500, 600, 150, 800, 2500};

        Hash04BestAlbum h4 = new Hash04BestAlbum();

                                              // Arrays.toString(배열담은 변수) : 파라미터로 배열을 입력받아서, 배열에 정의된 값들을 문자열 형태로 만들어서 리턴해준다.
        System.out.println("Best Album : " + Arrays.toString(h4.solution(genres, plays)));
    }
}

