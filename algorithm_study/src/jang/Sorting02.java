package jang;

import java.util.Arrays;
import java.util.Comparator;

//정렬 - 가장 큰 수
public class Sorting02 {
	
	public String solution(int[] numbers) {
		
		// * numbers 배열에 0 이 있는 경우 주의하기 - 문자열 "0"을 리턴시키는 예외 만들기  
		// * compareTo : 두 개의 문자, 숫자 비교 
		//		->숫자는 int반환 / 문자열에서 낮은 아스키코드 차이값을  반환
		// compareTo : 기본 정렬기준을 구현하는데 사용/ compare(obj1, obj2) : 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용
		
		// * 배열을 다루기 위해 제공된 메소드들이 Arrays - sort함수는 Comparator 인터페이스를 받아 주어진 기준에 따른 정렬
		
		// * 배열이 primitive 타입인 경우 Dual-Pivot QuickSort, Object 타입인 경우 Tim Sort를 사용
		// 		-> JAVA primitive type : 기본 자료형 / reference type : 클래스, 인터페이스, 배열, 열거 heap영역에 존재
		
		// 좀 더 찾아보기 !!!!
		// * Dual-Pivot QuickSort : InsertionSort + QuickSort 정렬 알고리즘
		//  	-> 2개의 피봇으로 퀵정렬
		// * Tim Sort :  InsertionSort + MergeSort 정렬 알고리즘
		//		-> MergeSort에 사용되는 추가 메모리 공간, 공간을 위해 소요되는 시간을 더 효율적으로 해결한 정렬 알고리즘
		//		-> 병합 정렬 + 삽입 정렬(그 중 이진 삽입 정렬)을 혼합 한 하이브리드 정렬
	   
		String answer = "";
	    
	    //numbers int 배열 크기만큼 String[] num 문자열배열로 저장해준다.
        String[] num = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            //num[i] = numbers[i] + "";
        	num[i] = String.valueOf(numbers[i]);
        }
        // 내림차순으로 정렬한다.    
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
                //오름차순 정렬 (obj1+obj2).compareTo(obj1+obj2);
            }
        });
        // 0 으로 시작하거나 0이 여러 개 이면 문자열인 하나의 0으로 반환한다.
    	if (num[0].equals("0")) {
			return "0";
		}
    	//정렬된 문자를 하나로 합친다.
    	for (String a : num) {
			answer += a;
		}
	    return answer;
	 }
    public static void main(String[] args) {
        
    	int[] numbers = {3, 30, 34, 5, 9};

    	Sorting02 s02 = new Sorting02();
    	
    }
}
