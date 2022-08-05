package Baekjoon;

import java.util.*;
import java.io.*;

//백준 1449번 수리공 항승
//테이프를 이용해서 물을 막는데 이때 그위치의 좌우 0.5만큼 간격을 줘야 물이 안샘
//테이프를 자를수 없고, 겹쳐붙이는게 가능함
public class Baekjoon_1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수
		int L = Integer.parseInt(st.nextToken()); // 테이프의 길이

		int broken[] = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i =0; i<N; i++) {
			broken[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(broken);
		
		//정렬하고 왼쪽부터 테이프 길이만큼보면서 맨왼쪽+테이프길이가 터진 위치보다 작으면 카운트늘리고 left값도 터진곳으로 바꿔줌
		//이때 옆에서 -0.5만큼 뺴줘야댐
		double left = broken[0] - 0.5;
		int count =1;
		for(int k=0; k<N ; k++) {
			if(left+L < broken[k]) {
				count++;
				left = broken[k] - 0.5;
			}
		}
		System.out.println(count);
	}
}
