package BOJ;

import java.io.*;

public class boj_1748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int numcnt = 1;
		int num = 10;
		
		for(int i = 1; i <= N; i++) {
			if(i % num == 0) { // Math.pow(10, numcnt);
				numcnt++;
				num *= 10;
			}
			count += numcnt;
		}
		
		System.out.println(count);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		// 10 100 1000
//		for(int i = 1; i <= N; i++) {
//			if(1 <= i && i <= 9) { 
//				count += 1;
//			} else if(10 <= i && i <= 99) {
//				count += 2;
//			} else if(100 <= i && i <= 999) {
//				count += 3;
//			} else if(1000 <= i && i <= 9999) {
//				count += 4;
//			} else if(10000 <= i && i <= 99999) {
//				count += 5;
//			} else if(100000 <= i && i <= 999999) {
//				count += 6;
//			} else if(1000000 <= i && i <= 9999999) {
//				count += 7;
//			} else if(10000000 <= i && i <= 99999999) {
//				count += 8;
//			} else {
//				count += 9;
//			}
//		}
//		System.out.println(count);
	}
}
