package BOJ;

import java.io.*;
import java.util.*;

public class boj_2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		int sum = 0; // 난쟁이 9명 키의 합
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		int num1 = 0;
		int num2 = 0;
 		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j ++) {
				if(sum - (arr[i] + arr[j]) == 100) {
					num1 = arr[i];
					num2 = arr[j];
					break;
				}
			}
		}
		
		for(int i: arr) {
			if(i == num1 || i == num2) {
				continue;
			}
			System.out.println(i);
		}
		
	}
}
