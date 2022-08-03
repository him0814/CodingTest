package baekjoon;
//�躸�� ���� 1764

//N: �赵 ���� ����� ��
//M: ���� ���� ����� ��
//N���� �ٿ� ���� �赵 ���� ����� �̸�, N+2° �ٺ��� ���� ���� ����� �̸��� ������� �־���

import java.io.*;
import java.util.*;

public class Deutbojap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> set = new HashSet<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String> al = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}	
		for(int j=0; j<M; j++) {
			String str = br.readLine();
			if(set.contains(str)){
				al.add(str);
			}
		}
		
		Collections.sort(al);
		System.out.println(al.size());
		for(String name: al) {
			System.out.println(name);
		}
	}
}
