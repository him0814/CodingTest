package Baekjoon;

//1초에 10억개의 데이터를 처리가능
//시간제한 1초 -> 1초에 10억개의 데이터를 처리가능
//N(1~1000) pi(1~1000)
//정렬해서 누적합을 계속 누적해서 더해주면됨

import java.io.*;
import java.util.*;

public class test {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		int answer = 0;
		int tmp =0;
		
		for(int i=0; i<N; i++) {
			tmp += time[i];
			answer += tmp;
		}
		System.out.println(answer);
	}
}
