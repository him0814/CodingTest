package BOJ;

/*
백준 #15903 카드 합체 놀이
시간제한 : 1초 -> 10억
n < 1,000 
m < 15,000

1. N장의 카드 중에서 가장 작은 두 수를 골라 더하고 고른 두 수를 그 값으로  바꾸어준다  
   -> 배열써서, 정렬하면 편할듯
2. 이후, 다시 카드 중에서 가장 작은 두 수를 골라 더하고 고른 두 수를 그 값으로  바꾸어준다
3. m번 반복 후 모든 
 */

import java.io.*;
import java.util.*;

public class boj_15903 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			Arrays.sort(arr);
			long sum = arr[0] + arr[1];
			arr[0] = sum;
			arr[1] = sum;
		}
		
		long total = 0;
		for(long i: arr) {
			total += i;
		}
		
		System.out.println(total);
	}
	
}
