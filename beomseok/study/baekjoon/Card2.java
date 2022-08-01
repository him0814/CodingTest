package baekjoon;
// ���� ī��2 2164

//1~N���� ��ȣ, 1��ī�� ���� �� N��ī�� ���� �Ʒ�
//N=4�϶�, 1234 ����  
//���� �� ������ -> ���� �� ���� �Ʒ��� �ű�� -> ���� ���� �� ���� �ݺ�

//ù° ��: ���� N(1 �� N �� 500,000)

import java.io.*;
import java.util.*;

public class Card2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			deq.offer(i);
		}
		while(deq.size() > 1) {
			deq.poll();
			deq.offer(deq.poll());
		}
		System.out.println(deq.poll());
	}
}
