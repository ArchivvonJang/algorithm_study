package jang;

import java.util.Arrays;

public class Sorting01 {
	
	public int[] solution(int[] array, int[][] commands) {
		// commands의 길이만큼 사이즈를 정해준다.
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
        	
        	// copyOfRange(배열, 시작인덱스, 끝인덱스) : 배열을 복사해준다. 원본배열, 복사시작할 인덱스, 마지막 인덱스       	
        	// copyOfRange로 자른 배열을 담아준다.       commands[i][0]-1 : 배열의 인덱스가 0부터 시작힉 때문에 -1을 해준다 (k번째 값은 k-1인덱스에 있으니까!)
            int arr[] = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            
            // sort로 오름차순 정렬해준다. 
            Arrays.sort(arr);
            
            //배열에 0,1,2 인덱스 값을 담아준다. 여기서 -1도 위와 같은 이유다. 
            answer[i] = arr[commands[i][2]-1];
        }
        return answer;
    }
    public static void main(String[] args) {
    
    	int[] array = {1, 5, 2, 6, 3, 7, 4};
    	
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    	Sorting01 s01 = new Sorting01();
    	
    	System.out.println(Arrays.toString(s01.solution(array, commands)));
    }
}
