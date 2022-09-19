package BOJ;

/*
���� #10816 ����ī��2
ī�带 N�� ������ ����
M���� ������ ���ڸ� �̾� N���� ī���� ������ ���� M�� ������ �ִ� ���� ���
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
