package Baekjoon;

import java.io.*;
import java.util.*;

//백준 9205번 맥주 마시면서 걸어가기
//맥주를 20병을 가지고 출발, 50미터가 되기전에 한병씩 마심, 맥주를 더구매해야될수도있음 가질수있는 맥주의 개수는 20병을 넘을수 없음
//맥주 구매하고나서도 50미터 가기전에 맥주한병을 마셔야함
//첫줄에 테스트케이스의 개수 t
//다음 줄부터 상근이네집 좌표, 편의점 집 좌표, 펜타포트 락 페스티벌 좌표가 주어짐(xy값 모두 -32768~32767)
//각 테스트 케이스에 대해 갈수있으면 happy, 더 이동할 수 없으면 sad를 출력한다.

public class Baekjoon_9205 {
	
	static int t; // 테스트케이스개수
	static int n; // 편의점의 개수
	static int[][] map;
	static int home; // 상근이 집좌표?
	static int gs; // 편의점 좌표?
	static int rock; // 락페스티벌좌표?
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			map = new int[];
			for(int j=0; j<4; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				
			}
		}
	}

}
