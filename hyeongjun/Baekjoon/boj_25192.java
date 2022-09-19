package BOJ;

/*
���� #25192
ENTER �Է½� ��� ������ �ǹ�
���ο� �г��� ������ ������ �̸�Ƽ�� ���
���� �г����� �� �ԷµǸ� ������ �̸�Ƽ�� ��� ����
������ �̸�Ƽ�� ��� Ƚ�� ���
 */

import java.util.*;
import java.io.*;

public class boj_25192 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_cnt = Integer.parseInt(br.readLine());
		Set<String> hs = new HashSet<>();
		
		int count = 0 ;
		
		for(int i = 0; i < test_cnt; i++) {
			String str = br.readLine();
			
			// String ������ ���� ���� equals 
			// == �ּҳ��� ��
			if(str.equals("ENTER")) { // ENTER �Է½� set �ʱ�ȭ
				count += hs.size();
				hs = new HashSet<>();
			} else {
				hs.add(str);
			}
		}
		System.out.println(count + hs.size());
	}
}
