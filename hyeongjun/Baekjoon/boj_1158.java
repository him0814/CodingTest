package study1;

/*
���� #1158
�似Ǫ�� ���� ����
1~N���� �ο��� ���� �׸��� �ɾ�����
������� K��° ����� N���� ����� ��� ���ŵɶ����� ��� ����
 */

import java.io.*;
import java.util.*;

public class boj_1158 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
				
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		
		while(!queue.isEmpty()) {
			for(int k = 0; k < K-1; k++) {
				int pollnum = queue.poll();
				queue.offer(pollnum);
			}
			if(queue.size() == 1) { // ������ ��� ���� �� ", " �ڿ� �� �ٰ� �ϱ�����
				int del_num = queue.poll();
				sb.append(del_num);
			} else {
				int del_num = queue.poll();
				sb.append(del_num).append(", ");
			}
		}
		//sb.setLength(sb.length()-1); ������ ��� �����
		sb.append(">");
		System.out.println(sb.toString());
	}
}
