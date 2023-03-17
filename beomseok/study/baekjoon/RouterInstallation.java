package baekjoon;
//백준 2110 공유기 설치 

import java.io.*;
import java.util.*;

public class RouterInstallation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
        int left = 1;
        int right = arr[N-1] - arr[0];
        int res = 0;
        int distance = 0;
        
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 1;
            int first = arr[0];
            for(int d: arr){
            	distance = d - first;
            	if(distance >= mid) {
            		cnt++;
            		first = d;
            	}
            }
            if(cnt < C){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
            res = mid;
        }
        
        System.out.println(res);
	}
}
