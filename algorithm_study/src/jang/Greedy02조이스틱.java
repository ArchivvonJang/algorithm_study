package jang;

public class Greedy02조이스틱 {
    static int solution(String name) {
        int answer = 0;
        int length = name.length();
        int updown; //위아래 움직임을 확인 확인
        int leftright = length - 1; //좌우 움직임을 확인 (오른쪽으로만 순서대로 이동하는 경우)

        // name 하나하나 돌면서 위아래좌우 움직임의 최소값을 구한다.
        for (int i = 0; i < length; i++) {

            //[1] 위아래로 이동한 거리의 최소값을 구한다.
            //문자열의 가중치(A부터,Z부터)중에 최소값을 반환하도록 한다.
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            //이동횟수 + 1 (알파벳을 변화시키기 위해 조이스틱을 움직이는 횟수 1)
            updown = i + 1;


            //[2] A를 만났을경우 A가 몇개 붙어있는지 조사하고 뒤돌아 가는 경우에 몇 번의 움직임이 발생하는지 찾는다.
            //A를 발견하면 그 시점부터 반복해서 A가 몇 개인지 확인하고 마지막 A를 알아낸다.
            while(updown < length && name.charAt(updown) == 'A') {
                updown++;
            }

            //[3] 좌우로 이동한 거리의 최소값을 구한다.
            //i부터 순서대로 가는 것, 뒤로 돌아서 가는 것 중에 최소값을 구한다.
            // i + i + (length-updown) 오른쪽으로 i만큼갔다가 다시 왼쪽으로 i만큼 가고, 연속된 A만큼(마지막A) 전체 길이에서 빼주는?
            leftright = Math.min(leftright, i * 2 + length - updown);

            //A부터 순서대로 가는 것, 처음부터 뒤로 돌아서 가는 것 중에 최소값을 구한다.
            // A만큼(length-updown) 갔다가 다시 A만큼(length-updown) 돌아와서 남은 알파벳(i)만큼 움직이기
            leftright = Math.min(leftright, ((length-updown)*2+i));

        }

        return answer + leftright;
    }
}
