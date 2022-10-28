package baekjoon;
//���� 1715 ī�� �����ϱ�

import java.io.*;
import java.util.*;

public class CardSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int bundle = Integer.parseInt(br.readLine());
			pq.offer(bundle);
		}
		
		int res = 0;
		while(pq.size() > 1) {
			int A = pq.poll();
			int B = pq.poll();
			
			pq.add(A+B);
			res += A+B;
		}
		
		System.out.println(res);
	}
}
