package baekjoon;
//백준 1463 1로 만들기

import java.io.*;

public class MakeIt1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N+1];
		arr[0] = 0;
	    arr[1] = 0;
	    
	    for(int i=2; i<N+1; i++){
	    	arr[i] = arr[i-1] + 1;
	    	if(i%3 == 0) {
	    		arr[i] = Math.min(arr[i], arr[i/3] + 1);
	    	} 
	    	if(i%2 == 0) {
	    		arr[i] = Math.min(arr[i], arr[i/2] + 1);
	    	}
	    }
	    
	    System.out.println(arr[N]);
	}
}
