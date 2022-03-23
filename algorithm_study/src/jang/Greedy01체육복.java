package jang;

public class Greedy01체육복 {
    static int solution(int n, int[] lost, int[] reserve) {
        //체육복있는 학생수를 반환해야하기 때문에 초기값은 학생수로 설정
        int answer = n;
        //학생 수만큼 학생마다 0부터 번호를 부여해준다.
        int [] student = new int[n];

        //체육복이 없는 학생의 번호는 -1 (0번부터 시작하기때문), 있으면 0보다 큰 수
        for(int l : lost) student[l-1]--;
        for(int r: reserve) student[r-1]++;

        //체육복 확인
        for(int i=0; i<student.length; i++){
            //체육복이 없는 경우 (학생 번호가 -1)
            if(student[i] == -1) {
                //체육복을 없다가 빌린 학생 번호를 ++ 해주고, 여분의 체육복을 빌려준 학생의 번호를 -- 처리한다.
                if(i-1 >= 0 && student[i-1] == 1) {
                    student[i]++;
                    student[i-1]--;

                    // 그 다음 번호 학생이 존재하고, 그 학생이 체육복이 있는 경우
                }else if(i+1<student.length && student[i+1] == 1) {
                    //체육복을 없다가 빌린 학생 번호를 ++ 해주고, 여분의 체육복을 빌려준 학생의 번호를 -- 처리한다.
                    student[i]++;
                    student[i+1]--;

                    //체육복을 빌려줄 왼쪽 오른쪽 학생(번호)가 없는 경우는 학생 수를 빼준다. (체육수업에 참여할 수 없다)
                }else {
                    answer--;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};

        System.out.println(solution(n, lost, reserve));
    }

}
