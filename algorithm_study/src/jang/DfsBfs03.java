package jang;

import java.io.IOException;

// 깊이넓이우선탐색 - 단어변환

// 단어는 한번에 한개의 알파벳만 변경가능!!! -> 두개는 가만히 있고 하나만 바꾸면되니까 두개먼저 비교
// word에 있는 단어로만 변환가능!!!

// 풀이를 생각해보자
// DFS
// 한글자빼고 나머지 word랑 비교
// 확인한건 visited = true
//
public class DfsBfs03 {

        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            // target이 word 안에 있을 때 (target과 word가 같은지 먼저 확인)
            if(isContain(target, words)) {

                boolean[] visited = new boolean[words.length];
                dfs(begin, target, words, visited, 0);

            // target이 word 안에 없을 때
            }else{
                answer = 0;
            }
            return answer;
        }// end solution



        // word안에 target이 있는지 확인
        static boolean isContain(String target, String[] words) {
            for(String word : words) {
                if(word.equals(target)) return true;
            }
            return false;
        }// end isContain

        // DFS
        static void dfs(String word, String target, String[] words, boolean[] visited, int cnt){
           for (int i = 0; i < words.length; i++){

               if(visited[i]) continue; //이미 확인했다면 지나가기

               int chk = 0;    // 같은 알파벳이 몇개인지 세기
               for (int j = 0; i < word.length(); j++){
                   // 시작 단어의 j번째 알파벳이 i번째 단어의 j번째 알파벳과 같다면
                   if(word.charAt(j) == words[i].charAt(j) ){
                       chk++;
                   } // end if


               if(chk == word.length() - 1){ //알파벳 하나 빼고 모두 같다면
                    //이부분은 이해가 안간다
                   visited[i] = true;

                   dfs(words[i], target, words, visited,cnt + 1);

                   visited[i] = false;
               }
               }// end for
           } // end for
        }// end dfs

    // BFS
    public  void bfs(String word, String target, String[] words, boolean[] visited, int cnt){

    }

    public  void main(String[] args) throws IOException {

       String begin = "hit";
       String target ="cog";
       String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println( "return : " + new DfsBfs03().solution(begin, target, words));// return 3개인데 왜.....
    }// end main

}// end class