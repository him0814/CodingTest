package BOJ;

/*
���� #14425
�Է� N���� ���ڿ� -> ���� S�� ���ϵǴ� ���ڿ�
�Է� M���� ���ڿ� -> �˻��ؾ��ϴ� ���ڿ�
hashmap ���
 */

import java.io.*;
import java.util.*;

public class boj_14425 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, String> hm = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 1~5��° ���ڿ��� hm.put()
		for(int i = 0; i < N; i++) {
			hm.put(br.readLine(), "a");
		}

		// �� ���� ���� �Ǿ� �ִ���
		int count = 0;
		
		// 1~11��° ���ڿ��� hashmap�� ���ԵǾ������� count++
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(hm.containsKey(str)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
