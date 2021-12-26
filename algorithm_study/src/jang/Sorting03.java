package jang;

import java.util.Arrays;

//정렬 - H-Index

public class Sorting03 {
	//citations중 최대값이 max부터 검사한다.
	//h번 이상 인용된 논문의 수인 cnt가 h편 이상이고
	//나머지가(len-cnt)가 h번 이하로 인용되면 answer에 값을 저장하고 검사를 중단한다.
	//h의 max를 찾는 것이므로 더 작은 값 확인은 생략한다. 
	
	public int solution(int[] citations) {
		
       int answer = 0;

       // 빠른 정렬을 위해 오름차순으로 정렬한다. 
       Arrays.sort(citations);
       // 인용횟수 담은 배열의 길이 
       int len = citations.length;
       // 인용횟수의 최대값은 전체길이 갯수 -1 개 
       int max = citations[len-1]; 
       // 인용된 논문 갯수를 담을 변수 
       int cnt = 0;
       //h의 max를 찾는다.
       for(int i = max; i>=0; i--){ 
    	 // 찾을 때까지 반복한다.   
           for(int j = 0; j<len; j++){
               if(citations[j]>=i) cnt+=1;
           }
           // 찾았다면 break, 탈출!
           if(cnt>=i && (len-cnt)<=i) {
               answer = i;
               break;
           }
       }
       return answer;
	
	}
	public static void main(String[] args) {
	

	}

}