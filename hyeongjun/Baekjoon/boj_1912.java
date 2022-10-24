package BOJ;

/*
���� #1912 ������

���ӵ� ������ �պ��� ������ ū ������ ������, �� ���� ������ �Ǹ� �ִ��� �� �� ����
-> ���ӵ� ������ �պ��� ������ ū ������ ������ ���� ���Ӱ��� ���� ���ؼ� �� �� �� �ִ��� ���
 */

import java.io.*;
import java.util.*;

public class boj_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; // ���� �Է�
		int[] tmp = new int[N]; // ���ӵ� ���� ���� ���� �迭
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		tmp[0] = arr[0];
		
		for(int i = 1; i < N; i++) {
			tmp[i] = Math.max(arr[i], tmp[i-1] + arr[i]);
			//System.out.println(tmp[i]);
		}
		
		Arrays.sort(tmp);
		System.out.println(tmp[N-1]);
	}
}
