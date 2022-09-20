package BOJ;

/*
���� #1541 �Ҿ���� ��ȣ
�ð� ����: 2�� -> 20��

������ -���θ� �Ǵ� +���θ� ������ �״�� ����
- ����� + ������ ������ ������ �پ��ִ� +������ ���� �� -���� 

< ��� >
1. StringTokenizer�� -�� ��, + �� ���� ������ �ϸ� �ɵ� -> ����.. -> hasmoretoken ����ϸ�ɵ�
2. �ڹ� ���ڿ� �ڸ��� -> �˻���� split
   2-1) split("-")�� �Ἥ  -�������� ������ �迭�� �־���
   2-2) split("+")�� �Ἥ +�������� ������ ���� ���� �տ��� ����
   2-3) ��, ù + ���갪�� �ʱ�ȭ���ִ� �۾��� �ʿ���
 */

import java.io.*;

public class boj_1541 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// 2-1) split("-")�� �Ἥ  -�������� ������ �迭�� �־���
		String[] m_arr = str.split("-"); // {55, 50+40}
		// ��� ���� �� ���� ���� ���� ���� ���� (���� ��)
		int sum = 0;
		
		for(int i = 0; i < m_arr.length; i++) {
			// �� ���� ������.. -> +
			// 2-2) split("+")�� �Ἥ +�������� ����
			String[] p_arr = m_arr[i].split("\\+"); // {(55),(50,40)}
			
			// +�������� ���� ������ ���� ���� ���� ����
			int total = 0;
			// +�������� ���� ������ ���� ���� total�� �־���
			for(int j = 0; j < p_arr.length; j++) {
				total += Integer.parseInt(p_arr[j]); // 55, (50+40)
			}
			
			// 2-3) ��, ù + ���갪�� �ʱ�ȭ���ִ� �۾��� �ʿ���
			if(sum == 0) { // sum�� m_arr�迭�� ù��° ���ҷ� �ʱ�ȭ
				sum = total;
			} else { // 2-2) ���� + ���곢���� ���� ���� �տ��� ����
				sum -= total;
			}
		}
		System.out.println(sum);
	}
}