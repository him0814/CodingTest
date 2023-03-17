package baekjoon;
//백준 1456 거의소수 

import java.io.*;
import java.util.*;

public class Almost_a_primeNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long arr[] = new long[10000001];
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		for(int i=2; i<arr.length; i++) {
			arr[i] = i;
		}
		
		for(int i=2; i<Math.sqrt(arr.length); i++) {
			if(arr[i] == 0) continue;
			for(int j=(i*2); j<arr.length; j=i+j) {
				arr[j] = 0;
			}
		}
		
		int res = 0;
		for(int i=2; i<arr.length; i++) {
			if(arr[i] != 0) {
				long tmp = arr[i]; 
				while((double)arr[i] <= (double)B/(double)tmp) {
					if((double)arr[i] >= (double)A/(double)tmp) {
						res++;
					}
					tmp *= arr[i];
				}
			}
		}
		System.out.println(res);
	}
}
