package baekjoon;
//���� ���� 2798

//ù° �ٿ� ī���� ���� N(3 �� N �� 100), M(10 �� M �� 300,000)
//��° �ٿ��� ī�忡 ���� �ִ� ���� �־�����, �� ���� 100,000�� ���� �ʴ� ���� ����
//���� M�� ���� �ʴ� ī�� 3���� ã�� �� �ִ� ��츸 �Է�
//ù° �ٿ� M�� ���� �����鼭 M�� �ִ��� ����� ī�� 3���� ���� ���

import java.io.*;
import java.util.*;

public class BlackJack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer> al = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			al.add(Integer.parseInt(st.nextToken()));
		}
		int sum = 0;
		int tmp = 0;
		for (int j = 0; j < n; j++) {
			for (int k = j + 1; k < n; k++) {
				for (int l = k + 1; l < n; l++) {
					sum = al.get(j) + al.get(k) + al.get(l);
					if (tmp < sum && sum <= m) {
						tmp = sum;
					}
				}
			}
		}
		System.out.println(tmp);
	}
}
