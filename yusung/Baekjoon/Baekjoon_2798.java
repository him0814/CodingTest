package Baekjoon;

import java.io.*;
import java.util.*;

//백준 2798번 블랙잭
//카드에는 양의 정수가 쓰여있음
//딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓고
//딜러는 숫자M을 제시함
//이때 N장의 카드중에서 M을 넘지 않으면서 M과 최대한 가깝게 만드는 숫자의 합을 출력함
//첫째줄에 카드개수 N(3~100) 만들 숫자 M(10~300000)
//둘째 줄에 카드에 쓰여있는 수가 주어짐(10만이하의 양의 정수)
//이때 합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어짐

//1초당 10억개
//N포문 3번 -> 100의 세제곱 -> 1,000,000

public class Baekjoon_2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int card[] = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int result = 0;
		for(int j=0; j<N-2; j++) {
			for(int k=j+1; k<N-1; k++) {
				for(int l=k+1; l<N; l++) {
					sum = card[j]+card[k]+card[l];					
					if(M==sum) {
						System.out.println(sum);
						return;
					}					
					else if(result<sum && sum<M) {
						result = sum;						
					}
				}
			}
		}
		System.out.println(result);
	}
}
