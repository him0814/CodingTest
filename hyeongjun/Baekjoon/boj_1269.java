package BOJ;

/*
���� #1269 ��Ī������
���� A, ���� B�� ���ΰ��� �������� ������ ������ ���ϸ��
A-B ���� + B-A ���� 
 */

import java.util.*;
import java.io.*;

public class boj_1269 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> a_hs = new HashSet<>();
		Set<Integer> b_hs = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// a_hs�� 1,2,4 �߰�
		for(int i = 0; i < a; i++) {
			a_hs.add(Integer.parseInt(st.nextToken()));
		}
				
		st = new StringTokenizer(br.readLine(), " ");
		
		// b_hs�� 2,3,4,5,6 �߰�
		for(int i = 0; i < b; i++) {
			b_hs.add(Integer.parseInt(st.nextToken()));
		}
		
		int count = 0;
		
		for(int now: a_hs) {
			// a_hs�� ���Ե��� ������ count++
			if(!b_hs.contains(now)) {
				count++;
			}
		}
		
		for(int now: b_hs) {
			// bs_hs�� ���Ե��� ������ count++
			if(!a_hs.contains(now)) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
