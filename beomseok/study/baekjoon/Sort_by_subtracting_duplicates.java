package baekjoon;
//�ߺ� ���� �����ϱ� ���� 10867

import java.io.*;
import java.util.*;

//N���� ����, ������������ ����
//ù° �ٿ� ���� ���� N (1 �� N �� 100,000)
//��° �ٿ� ������ 1,000���� �۰ų� ���� ����

public class Sort_by_subtracting_duplicates {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();

		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		ArrayList<Integer> al = new ArrayList<>(set);
		Collections.sort(al);
		for (int num : al) {
			System.out.print(num + " ");
		}

	}
}
