package jang;

//정렬 - 가장 큰 수
public class Sorting02 {
	
	public String solution(int[] numbers) {
		//반환 타입이 String! -> 정수열을 문자열로 변경해준다.
		// 두 정수를 어느 순서로 이어붙이느냐에 따라 만들 수 있는 수의 크기가 다르다는 것은 문자열 두개를 다른 순서로 이었을 때 첫 문자부터 비교를 시작하여 문자 값이 다른 구간이 존재한다라는 것을 의미합
		//풀이 생각해보기
		//1. 선 숫자 조합 후 최대값 찾기
		//2. 숫자 조합하면서 큰 순서로 정렬
		//3. 둘 다 틀림 문자열로 변경하므로 문자열 그대로 반환하는 방법을 생각
		// * numbers 배열에 0 이 있는 경우 주의하기 - 문자열 "0"을 리턴시키는 예외 만들기  
		// * compareTo 
		// * 배열을 다루기 위해 제공된 메소드들이 Arrays에 있으며 sort함수는 Comparator 인터페이스를 받아 주어진 기준에 따른 정렬을 수행할 수 있습니다.
		// * 배열이 primitive 타입인 경우 Dual-Pivot QuickSort, Object 타입인 경우 Tim Sort를 사용
		//Dual-Pivot QuickSort : InsertionSort와 QuickSort를 결합한 정렬 알고리즘
		// Tim Sort :  InsertionSort와 MergeSort를 결합한 / MergeSort에 사용되는 추가 메모리 공간, 공간을 위해 소요되는 시간을 더 효율적으로 해결한 정렬 알고리즘

	    String answer = "";
	    
	    //numbers int 배열 크기만큼 String[] num 문자열배열로 저장해준다.
        String[] num = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            num[i] = numbers[i] + "";
        }
        // 내림차순
        // 붙이기
        // 0 내림차순
        
	    return answer;
	 }
    public static void main(String[] args) {
        
    	int[] numbers = {3, 30, 34, 5, 9};

    	Sorting02 s02 = new Sorting02();
    	
    //https://codevang.tistory.com/294
    //https://ivory-room.tistory.com/43	
    	//https://immose93.tistory.com/117
    }
}
