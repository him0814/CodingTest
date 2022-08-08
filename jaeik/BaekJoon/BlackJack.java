package BaekJoon;

// N장의 카드 중에 3장을 골라 M에 가장 가깝게
// 숫자 M

import java.util.*;
import java.io.*;
public class BlackJack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] card = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		int tmp = 0;
		for(int x = 0; x < N-2; x++) {
			for(int y = x + 1; y < N-1; y++) {
				for(int z = y + 1; z < N; z++) {
					int sum = card[x] + card[y] + card[z];
					if(sum == M) {
						tmp = sum;
						break;
					}
					else if(sum > tmp && sum <M) {
						tmp = sum;
					}
				}
			}
		}
		System.out.print(tmp);
	}
}
