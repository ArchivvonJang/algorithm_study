package moon;

import java.util.LinkedList;
// 시간 ++ : 트럭이 다리 한칸 옮기거나 다리에 오르는 경우 (트럭이 다리에서 내리는데 시간 추가 X)
// 먼저 들어온 트럭이 먼저 나가는 선입선출
// 뒤에 올 트럭을 위해 이동할 때는 ++, 다리가 꽉 찬 후에 트럭들이 다같이 이동할 때는 한번에 이동하니까 +1로 퉁. 트럭이 추가되면서 앞 트럭이 이동하는 것은 +1로 퉁
public class 스택큐_다리를지나는트럭 {
    int time = 0;
    LinkedList<Integer> bridgeQu = new LinkedList<>();  // 중복 허용
    int bridgeWeight= 0;

    public int solution(int bridge_length, int weight, int[] truck_weights) {
//        Integer[] truckWeightsInteger = Arrays.stream(truck_weights).boxed().toArray(Integer[]::new);        // int -> Integer로 한번에 변환 : 6.5배...

        for (int truck : truck_weights) {
            while (true) {
                // 다리에 트럭 이 없는 경우
                if (bridgeQu.isEmpty()) {
                    addTruck(truck);
                    break;
                }
                // 다리에 트럭이 다 찬 경우 빼주고~
                else if (bridgeQu.size() == bridge_length) {
                    bridgeWeight -= bridgeQu.poll();    // 트럭 빼면서 무게도 빼기
                }
                // 다리가 차지 않은 경우
                else {
                    // 다음 트럭이 올 수 있는 무게인지 확인
                    if ((bridgeWeight + truck) <= weight) {
                        addTruck(truck);
                        break;
                    }
                    //  올수 없는 무게면
                    else {
                        moveTruck();
                    }
                }
            }
        }
        return time + bridge_length;    // 마지막에 다리에 오른 트럭이 이동 후 내려야하니까 다리길이만큼 시간 추가
    }
    public void addTruck (int truck) {
        bridgeQu.add(truck);
        bridgeWeight += truck;
        time++;
    }
    public void moveTruck() {
        bridgeQu.add(0);
        time++;
    }

    public static void main(String[] args) {
        스택큐_다리를지나는트럭 k = new 스택큐_다리를지나는트럭();
        long startTime = System.currentTimeMillis();
//        int answer = k.solution(3, 17, new int[]{7, 4, 5, 6});
         int answer = k.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
        long endTime = System.currentTimeMillis();
        System.out.println(answer);
        System.out.print(endTime - startTime);
    }
}
