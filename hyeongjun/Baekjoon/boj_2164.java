package study1;

/*
 ���� #2064
 N���� ī�� �� �� ���� �ִ� ī�带 ������ 
 �� ���� ���� ���� �ִ� ī�带 ī�� �� �Ʒ��� �ű��
 N�� �־����� �� ���� �������� ���� �Ǵ� ī�带 ���ϱ�
 */


import java.io.*;
import java.util.*;

public class boj_2164 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<>();
		
		int testcnt = Integer.parseInt(br.readLine());
		
		// testcnt�� N���� ī�带 N,N-1,...,2,1 ������ ���� for��
		for(int i = 0; i < testcnt; i++) {
			deque.offerFirst(i+1); 
		}
		
		// ���� �� �־��� ���� ���� for��
		for(int i = 0; i < testcnt; i++) {
			
			// deque ����� 1�϶� ������ ����
			if(deque.size() == 1) {
				break;
			} else {
				deque.pollLast(); //�� ���� ����
				deque.offerFirst(deque.pollLast()); // �� ���� �� ���� �� �Ʒ���
			}
		}
		
		sb.append(deque.peek());
		System.out.println(sb.toString());
				
	}
	
}