package jang;

import java.util.*;
import java.util.HashMap;
// 해시 - 베스트 앨범
// answer 배열에 출력될 순서
// 속한 노래가 많이 재생된 장르 먼저
// 장르 내에서 많이 재생된 노래 먼저
// 장르 내에서 재생 횟수가 같은 노래는 고유번호가 낮은 번호 먼저

class Song implements  Comparable<Song>{
    int index;
    int count;

    public Song(int index, int count){
        this.index = index; //고유번호
        this.count = count; // 재생횟수
    }
    //재생된 노래 비교하기
                //객체간의 비교를 가능하게 해주는 인터페이스 Comparable<T>의 메소드
    public int compareTo(Song other){
        // 재생 횟수가 같다면, 고유번호 정렬해주기
        if(this.count == other.count)
            return Integer.compare(this.index, other.index);

       // System.out.println("D 1 > this.index : " +this.index + " / other.index : " + other.index );
       // System.out.println("D 2 > this.count : " + this.count + " / other.count : " + other.count);
        //다르다면 재생횟수 정렬
        return Integer.compare(other.count, this.count);
    }

}
public class Hash04BestAlbum {

    public int[] solution(String[] genres, int[] plays) {

        int[] answer = {};

        //조건에 부합하는 고유번호를 담을 List
        List<Integer> result = new ArrayList<Integer>();
        //장르, 재생횟수
        HashMap<String, Integer> genreMap = new HashMap<>();
        //장르, 장르에 속한 노래
        HashMap<String, ArrayList<Song>> playGenreMap = new HashMap<>();

        for(int i =0; i<genres.length; i++) {

            String genre = genres[i]; // 장르
            int play = plays[i]; //재생 횟수


            //genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0)+plays[i]); 장르마다 총 누적 재생횟수를 저장
            // <장르, 재생횟수 > Map에 담아준다.
            // getOrDefault(a,defaultValue) : 이미 장르가 존재하면 2번째 매개변수로 적은 기본값으로 설정한다.
            // 기본값에 play 의 값을 더해준다.
            genreMap.put(genre, genreMap.getOrDefault(genre,0) + play);

            // 장르별 노래 등록
            // computeIfAbsent : 해당 값이 키값으로 없는 경우 두번째 인자로 준 함수를 실행하여 기본값으로 설정한다.
            //                    만약 해당 장르가 Map에 존재하지 않으면, 새로운 ArrayList를 만들어서 새로운 노래를 추가해준다.
            playGenreMap.computeIfAbsent(genre, s -> new ArrayList<>() ).add(new Song(i, play)) ;

            //System.out.println("A > computeIfAbsent -> genre : " + genre +" / i :" + i + " / play : " + play );

            //--> // merge method알아보기 이걸 쓰면 getOrDefault, computeIfAbsent 한번에 처리할 수 있다!! 알아보기!!
        }


        // 장르의 총 누적 재생횟수가 계산되면 그것을 기준으로 정렬을 해준다.
        // Map에서 Value 기준으로 정렬이 어려우므로 Map을 List로 변환
        List<String> keyList = new ArrayList<>(genreMap.keySet());

        // 재생 횟수를 정렬한다.
        //                                      compareTo() : 음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
        keyList.sort((o1, o2) -> (genreMap.get(o2).compareTo(genreMap.get(o1))));

       // System.out.println("////////////////////////////////////////");
        //System.out.println(" B > keyList sort" +  keyList);

        //정렬된 장르를 돌면서
        for(String key : keyList){
            // 장르에 속한 노래 목록
            ArrayList<Song> tracks = playGenreMap.get(key);

            // 재생 횟수를 정렬한다. 정렬 횟수가 같으면 고유번호 (인덱스 순으로 정렬)
            Collections.sort(tracks);

           // System.out.println(" C > tracks : " + tracks + " / key : " + playGenreMap.get(key));

            int idx = 0;
            for(Song song : tracks){
                if(idx > 1) break;
                result.add(song.index);
              // System.out.println("E 1 > " + idx + "의 result : "+ result + " / song :" + song + " / song.index : " + song.index);
                idx++;
              //  System.out.println("E 2 > idx++ : " +idx);
            }
        }

        // ArrayList에 담긴 앨범을 int배열로 옮긴다.
        // 앨범이 담긴 result 크기만큼 초기화
        answer = new int[result.size()];
        int index = 0;

        // 앨범(노래 목록)을 돌면서 배열에 담아준다.
        for(Integer i : result){

           // System.out.println(" F > result" + result + " / i : " + i);
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

        //System.out.println("A - B - C - D - E - D - F(반복문으로 담기) 순으로 반복 ");
        System.out.println(" Best Album : " + Arrays.toString(h4.solution(genres, plays)));
    }
}

