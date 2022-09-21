package BOJ;

/*
���� #15903 ī�� ��ü ����
�ð����� : 1�� -> 10��
n < 1,000 
m < 15,000

1. N���� ī�� �߿��� ���� ���� �� ���� ��� ���ϰ� �� �� ���� �� ������  �ٲپ��ش�  
   -> �迭�Ἥ, �����ϸ� ���ҵ�
2. ����, �ٽ� ī�� �߿��� ���� ���� �� ���� ��� ���ϰ� �� �� ���� �� ������  �ٲپ��ش�
3. m�� �ݺ� �� ��� 
 */

import java.io.*;
import java.util.*;

public class boj_15903 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			Arrays.sort(arr);
			long sum = arr[0] + arr[1];
			arr[0] = sum;
			arr[1] = sum;
		}
		
		long total = 0;
		for(long i: arr) {
			total += i;
		}
		
		System.out.println(total);
	}
	
}
