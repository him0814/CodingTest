package BOJ;

/*
백준 #10816 숫자카드2
카드를 N개 가지고 있음
M개의 임의의 숫자를 뽑아 N개의 카드중 임의의 숫자 M을 가지고 있는 갯수 출력
 */

import java.io.*;
import java.util.*;

public class boj_10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		int cardcnt = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < cardcnt; i++) {
			int cardnum = Integer.parseInt(st.nextToken());
			//hm.put(cardnum, hm.getOrDefault(cardnum, 0) + 1);
			if(hm.containsKey(cardnum)) {
				hm.put(cardnum, hm.get(cardnum)+1);
			} else {
				hm.put(cardnum, 1);
			}
		}
		
		int choice_cnt = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < choice_cnt; i++) {
			int choice_cardnum = Integer.parseInt(st.nextToken());
			if(hm.containsKey(choice_cardnum)) {
				sb.append(hm.get(choice_cardnum)).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}
