package jang;


/* 동적계획법 - 도둑질
 *1. 첫번째 집을 털면 마지막 집은 털 수 없다. 집들이 원형으로 연결되기 때문에 첫번째 집과 이웃하게된다.
 *2. 두번째 집을 털면 첫번째 집은 털 수 없다.
 *3. n번째 집 다음 n+1번째 집은 털수가 없기 때문에, n+2와 n+3 집중에서 큰돈을 가진 집을 선택해야한다.
 * */
public class DynamicProgramming04Money {

    static int solution(int[] money) {
        int len = money.length;
        int[][] home = new int[2][len]; //home[0][] : 첫번째 집을 터는 경우, home[1][] : 첫번째 집을 털지 않는 경우

        //1. 첫번째 집을 도둑질하는 경우 - 첫 번째 집을 털면, 두 번째 집을 털 수 없다. 두 번째 집을 가더라도 최댓값은 첫 번째 집 Money
        home[0][0] = money[0];
        home[0][1] = money[0];


        //2. 두번째 집을 도둑질하는 경우 - 첫 번째 집을 털지 않으면, 두 번째 집으로 이동했을 때 두 번째 집을 털 수 있으므로 최대값은 두 번째 집 Money
        home[1][0] = 0;
        home[1][1] = money[1];


        // 첫번째를 포함 경우 - 마지막 도둑질 값은 구하지 않는다(첫번째 선택시 마지막 집 도둑질은 불가능하다)
        for(int i = 2; i< len; i++) {
            //현재 해당 집 도둑질 비교 후 최대값을 넣는다.
            home[0][i] = Math.max(home[0][i-2] + money[i], home[0][i-1]);
            home[1][i] = Math.max(home[1][i-2] + money[i], home[1][i-1]);
        }

        // 두번째를 포함 경우 - 마지막 집 도둑질 가능
        //home[0]은 마지막 집을 털 수 없으므로 마지막 집을 터는 계산은 home[1]만 한다.
        home[1][len - 1] = Math.max(home[1][len-3] + money[len-1], home[1][len-2]);

        //둘 중에 최대 값을 반환한다.
        return Math.max(home[0][len-2], home[1][len-1]) ;
    }
}
