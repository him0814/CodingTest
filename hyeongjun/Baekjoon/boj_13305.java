package BOJ;

/*
백준 #13305 주유소
시간제한 2초 -> 20억개

  2   3   1
5---2---4---1               -> 18

  3   3   4
1---1---1---1               -> 10

처음엔 기름이 없으므로 첫번재 주유소에서 첫 도로 길이 만큼 넣어줘야함
(두 번째 기름값)부터 (마지막 기름값-1) 까지 비교하여 가장 싼 기름값에서 남은 도로 길이만큼을 주유해야함
단, 제일 싼 주유소를 들리기 전까진 그 도시에서 다음 도시까지의 도로 길이 만큼만 주유
 */

import java.io.*;
import java.util.*;

public class boj_13305 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						
		int city_cnt = Integer.parseInt(br.readLine());
		
		long[] street = new long[city_cnt - 1];
		long[] oil_price = new long[city_cnt];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < city_cnt - 1; i++) {
			street[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < city_cnt; i++) {
			oil_price[i] = Long.parseLong(st.nextToken());
		}
		
		// long = int * int 안됨
		// long = int * long      or        long = long * long
//		long num = 1000000 * 1000000;
//		long num1 = 1000000 * (long)1000000;
//		
//		System.out.println(num+" "+num1);
				
		// 첫 번째 도시에선 무조건 첫 도로 길이만큼 주유해야함
		long total = oil_price[0] * street[0]; // 10억x10억 = int (-21억~21억) 범위를 넘어감
		long min = oil_price[0];
								
		for(int i = 1; i < city_cnt - 1; i++) {
			// 2 ~ n-1 을 지나면서 min값이 나오기 전까진 oil_price * street
			if(oil_price[i] < min) {
				total += oil_price[i] * street[i];
				min = oil_price[i];
			} else {
				total += min * street[i];
			}
 		}
		System.out.println(total);
	}
}
