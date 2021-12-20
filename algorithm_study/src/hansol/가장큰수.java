package hansol;

import java.util.ArrayList;
import java.util.List;

public class 가장큰수 {
    public String solution(int[] numbers) {
        List<Integer> numbersArr = new ArrayList<>();
        int zeroCount = 0;
        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
            if (number == 0){ zeroCount++;}
            numbersArr.add(number);
        }
        if (zeroCount == numbers.length) {
            return "0";
        }

        List<Integer> sortedArr = quickSort(numbersArr);
        for (Integer value : sortedArr) {
            sb.append(value);
        }

        return sb.toString();
    }

    private List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        Integer pivot = list.get(0);
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            Integer value = list.get(i);
            if (isGrateThan(value, pivot)) {
                rightArr.add(value);
                continue;
            }
            leftArr.add(value);
        }

        List<Integer> mergedArr = new ArrayList<>(quickSort(leftArr));
        mergedArr.add(pivot);
        mergedArr.addAll(quickSort(rightArr));

        return mergedArr;
    }

    private boolean isGrateThan(Integer source, Integer target) {
        String value1 = String.valueOf(source + target);
        String value2 = String.valueOf(target + source);

        return value1.compareTo(value2) < 0;

    }


}
