package baekjoon;
// �Ҿ���� ��ȣ ���� 1541

// ù° �ٿ� ����, '0��~��9��, ��+��, �׸��� ��-�������� �̷����.
// �����ؼ� �� �� �̻��� �����ڰ� ��Ÿ���� �ʰ�, 5�ڸ����� ���� ���ӵǴ� ���ڴ� ����.

import java.io.*;
import java.util.*;

public class Lost_Parenthesis {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st2 = new StringTokenizer(br.readLine(),"-");
		
		ArrayList<Integer> al = new ArrayList<>(); 
		
		while(st2.hasMoreTokens()) {
			int sum =0;
			StringTokenizer st1 = new StringTokenizer(st2.nextToken(),"+");
			while(st1.hasMoreTokens()) {
				int idx = Integer.parseInt(st1.nextToken());
				sum += idx;
			}
			al.add(sum);
		}
		int firstIdx = al.get(0);
		for(int i=1; i<al.size(); i++) {
			firstIdx -= al.get(i);
		}
		System.out.println(firstIdx);
	}
}
