package BOJ;

/*
백준 #1436 영화감독 숌

예제입력에 너무 집착x
문제 그대로 풀면됨

666 1666 2666 3666 4666 5666 6660 ...
666부터 시작하여 1씩 증가 -> 666포함 되어 있으면 count++
count == N 일 때 숫자 출력
 */

import java.io.*;

public class boj_1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int num = 666;
		int count = 1;
		
		while(count != Integer.parseInt(N)) {
			num++;
			int tmp = num;
			while(true) {
				if(tmp < 666) {
					break;
				}
				if(tmp % 1000 == 666) { // 
					count++;
					break;
				} else {
					tmp /= 10;
				}
			}
 		}
		
//		while(count != Integer.parseInt(N)) {
//			num++;
//			if(Integer.toString(num).contains("666")) {
//				count++;
//			}	
//		}
		
		System.out.println(num);
	}
}