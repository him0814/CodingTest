package BOJ;

/*
���� #2346
1~N ���� ǳ���� 1������ �Ͷ߸���
ǳ�� �ȿ��� -N~N���� ������ �ְ�
N>0, N��ŭ �������� ǳ�� �Ͷ߸�
N<0, N��ŭ ������ ǳ�� �Ͷ߸�
��, ���� ǳ���� ���� ����
 */

import java.io.*;
import java.util.*;

public class boj_2346 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// queue�� ������� ��������� �����̸鼭 ���������ϹǷ� ����
		Deque<int[]> deque = new ArrayDeque<>();
		
		int test_cnt = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < test_cnt; i++) {
			deque.offer(new int[] {(i+1), Integer.parseInt(st.nextToken())}); // �ε��� / ǳ����ȣ
		}
		
		// ù��° ǳ�� ���� ����
		sb.append("1 ");
		int[] arr = deque.poll();
		int num = arr[1];
		
		while(!deque.isEmpty()) {
			if(num > 0) {
				for(int k = 1; k < num; k++) {
					deque.offerLast(deque.pollFirst());
				}
				int[] next_num = deque.poll();
				num = next_num[1];
				sb.append(next_num[0]+" ");
			}
			else { // num < 0
				for(int l = 1; l < -num; l++) {
					deque.offerFirst(deque.pollLast());
				}
				int[] next_num = deque.pollLast();
				num = next_num[1];
				sb.append(next_num[0]+" ");				
			}
		}
		System.out.println(sb.toString());
	}
}
