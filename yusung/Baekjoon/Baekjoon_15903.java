package Baekjoon;

import java.io.*;
import java.util.*;

//백준 15903번 카드 합체 놀이
//1초 추가시간 없음
//1. x번 카드와 y번 카드를 골라 그 두장에 쓰여진 수를 더한 값을 계산한다.(x!=y)
//2. 계산한 값을 x번 카드와 y번 카드 두장 모두에 덮어 쓴다.
//이 합체를 총 m번하면 놀이가 끝난다. 이때 점수를 가장 작게 만드는 것이 놀이의 목표이다.
//입력 첫번째 줄에 카드의 개수를 나타내는 수 n(2~1000), 카드 합체를 몇 번 하는지 나타내는 수m이 주어진다.
//백만 + 백만 만오천번을 더함 -> 백만*15000
//150억 -> 인트값 범위를 넘어감(-21억~+21억)
//따라서 배열과 결과값은 long으로 선언해야함

// 2 3 6
// 5 5 6

// 1 2 3 4
// 3 3 3 4
// 6 6 3 4

public class Baekjoon_15903 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long card[] = new long[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {			
			int num = Integer.parseInt(st.nextToken());
			card[i] = num;
		}
		
		for(int j=0; j<m; j++) {
			Arrays.sort(card); // 합쳐지면 수가 바뀌니까 합쳐질때마다 정렬해야됨
			long sum = card[0]+card[1];
			card[0] = sum;
			card[1] = sum;
		}
		
		long result = 0;
		for(int k=0; k<card.length; k++) {
			 result += card[k];
		}
		
		System.out.println(result);
	}
}
