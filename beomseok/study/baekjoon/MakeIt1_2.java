package baekjoon;
//백준 12852 1로 만들기 2

import java.io.*;

public class MakeIt1_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N+1];
		arr[0] = 0;
	    arr[1] = 0;
	    
	    int path[] = new int[N+1];
	    
	    for(int i=2; i<N+1; i++){
	    	arr[i] = arr[i-1] + 1;
	    	path[i] = i - 1;
	    	
	    	if(i%3 == 0) {
	    		if(arr[i/3]+1 < arr[i]) {
					arr[i] = arr[i/3] +1;
					path[i] = i/3;
				}
	    	} 
	    	if(i%2 == 0) {
	    		if(arr[i/2]+1 < arr[i]) {
					arr[i] = arr[i/2] +1;
					path[i] = i/2;
				}
	    	}
	    }
	    System.out.println(arr[N]);
	    
	    StringBuilder sb = new StringBuilder();
	    while(N > 0){
            sb.append(N).append(" "); 
            N = path[N];
        }
	    
	    System.out.println(sb);
	}
}
