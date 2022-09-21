package BOJ;

/*
���� #1449 ������ �װ�
�ð�����: 2�� -> 20��
N,L -> ���� 1000

1. ó�� ���� ���� �� (N -0.5) +L 
2. ���� �� ���°� (N+1-0.5) < (N -0.5) +L ���� ������ ������ ���� �ʿ� ����
3. (N -0.5) +L < (N+1-0.5) �� �Ǵ� ������ �ٽ� �������� ���̸� ��
 */

import java.io.*;
import java.util.*;

public class boj_1449 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // �� ���� �� ����
		int L = Integer.parseInt(st.nextToken()); // �������� ����
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// �� ���� ���� arr �迭�� ����
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// ���� �Է�3 ���� 3 2 1�� ��� ���� �ֱ� ������ ����
		Arrays.sort(arr);
		
		// 1. ó�� ���� ���� �� (N -0.5) +L 
		double range = (arr[0] - 0.5) + L; // ex) 3.5
		int count = 1; // ������ ���� -> �̹� �ϳ� ���� ����
		
		for(int i = 0; i < arr.length; i++) {
			// 2. ���� �� ���°� (N+1-0.5) < (N -0.5) +L ���� ������ ������ ���� �ʿ� ����
			if(range <= arr[i] - 0.5) {
				// 3. 3. (N -0.5) +L < (N+1-0.5) �� �Ǵ� ������ �ٽ� �������� ���̸� ��
				range = arr[i] - 0.5 + L;
				count++; // ������ ���� +1
			}
		}
		
		System.out.println(count);
	}
}
