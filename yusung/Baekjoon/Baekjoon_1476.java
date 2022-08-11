package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1476번 날짜 계산
//e는 1~15, s는 1~28, m는 1~19
//현재 년도에서 15, 28, 19로 나눴을때 나머지가 0일 경우에만 출력 > 모두 만족해야됨
//이후에는 계속 늘려줌

public class Baekjoon_1476 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int now = 0;
		
		while(true) {
			now++;
			if((now-e)%15==0 && (now-s)%28==0 && (now-m)%19==0) {
				break;
			}
		}
		
		System.out.println(now);
	}
}
