package study1;

// ���� #2675
// ���ڿ� S�� ���� �� �� ���ڸ� R�� �ݺ��� ���ο� ���ڿ� P�� ����� ���
// S���� QR Code "alphanumeric"   / QR Code "alphanumeric" answksms 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./:
// ù°�ٿ��� �׽�Ʈ ���̽� ���� T(1<=T<=1000)
// �׽�Ʈ���̽� �ݺ� Ƚ�� R(1<=R<=8)
// ���ڿ� S�� �������� ����, S�� ���̴� ��� 1, 20���� ��������

import java.io.*;
import java.util.*;

public class boj_2675 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// �׽�Ʈ ���̽� ���� �Է�
		int testcnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < testcnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// ���ڰ� �ݺ��� ��
			int cnt = Integer.parseInt(st.nextToken());
			// �ݺ��� ���ڸ� ������ String �迭
			String word = st.nextToken();

			for (int j = 0; j < word.length(); j++) {
				for (int k = 0; k < cnt; k++) {
					// System.out.print -> �̾ ���
					// System.out.println -> ����ϰ� \n �� ���
					// @@@@str.charAt(i) -> str ���ڿ��� i+1��° ����, �� str�� charŸ������ ��ȯ�ϴ� ����@@@@
					// System.out.print(word.charAt(k));
					// toCharArray(); ã�ƺ���  
					// split(); ã�ƺ���
					// �⺻������ ()�Ⱥ��� ex) String[] , ���������� ()���� String ������ ()����
					sb.append(word.charAt(j));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}