package BOJ;

/*
���� #1436 ��ȭ���� ��

�����Է¿� �ʹ� ����x
���� �״�� Ǯ���

666 1666 2666 3666 4666 5666 6660 ...
666���� �����Ͽ� 1�� ���� -> 666���� �Ǿ� ������ count++
count == N �� �� ���� ���
 */

import java.io.*;

public class boj_1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int num = 666;
		int count = 1;
		
		while(count != Integer.parseInt(N)) {
			num++;
			int tmp = num;
			while(true) {
				if(tmp < 666) {
					break;
				}
				if(tmp % 1000 == 666) { // 
					count++;
					break;
				} else {
					tmp /= 10;
				}
			}
 		}
		
//		while(count != Integer.parseInt(N)) {
//			num++;
//			if(Integer.toString(num).contains("666")) {
//				count++;
//			}	
//		}
		
		System.out.println(num);
	}
}