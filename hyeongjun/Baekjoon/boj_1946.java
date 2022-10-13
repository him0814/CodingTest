package BOJ;

/*
���� #1946 ���� ���
�ð�����: 2�� -> 20��
N <= 100,000

1. (key-> ��������, value -> ���� ����)  Ʈ���ʿ� ����
	
	k v
	---
	1 4  -> ���������� 1���� �̹Ƿ� ������ ����
	2 5 
	3 6 
	4 2
	5 7 
	6 1
	7 3
	
2. ���� ���� 2���� ����� ���� ������ 5���ε� �� �ε��� ���� �������� �� ����
3. ���� ���� �����̹Ƿ� ���� ������ �������Ƿ� �� �ε����� ���� �������� ���ƾ� ���ߵ�
   -> value���� �� �ε��� value���� ���ؼ� ������ ���� 
 */

import java.io.*;
import java.util.*;

public class boj_1946 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Map<Integer, Integer> tm = new TreeMap<>();
			
			// 1. (key-> ��������, value -> ���� ����)  Ʈ���ʿ� ����
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				tm.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int min = tm.get(1);
			int count = 1;
			
			// 3. ���� ���� �����̹Ƿ� ���� ������ �������Ƿ� �� �ε����� ���� �������� ���ƾ� ���ߵ�
			for(int j: tm.keySet()) {
				if(tm.get(j) < min) {
					min = tm.get(j);
					count++;
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());
	}
}
