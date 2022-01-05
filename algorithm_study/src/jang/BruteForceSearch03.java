package jang;
// 완전탐색 - 카펫
public class BruteForceSearch03 {
        public int[] solution(int brown, int yellow) {

            //{width, height}
            int[] answer = new int[2];

            //brown의 w와 l는 무조건 yellow의 갯수+2
            //yellow가 1개는 반드시 있기 때문에 가로 w또는 세로 l의 갯수는 3이상
            //w*l 는 전체 갯수
            //w≥=l
            //yellow = (w-2)*(l-2)
            // brown의 갯수는 width 2개 더하고 양쪽 height는 width와 겹치는 모퉁이를 2개를 각각빼준다
            //brown = w*2 + (height-2)*2

            //아무튼 높이는 최소 3개부터고, brown의 반절보다는 적게 있을 것이다.
            for(int height=3;height<(brown/2); height++)
            {
                //width 한 줄 만 구하기 위해서 대각선으로 자른모양에서 양쪽 모퉁이를 살리고 높이 빼기
                int width = (brown/2)+2-height;
                //조건에 맞다면 담기
                if(((height-2)*(width-2)) == yellow)
                {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
            return answer;
        }
}
