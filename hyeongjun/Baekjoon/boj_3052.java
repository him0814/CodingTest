package study1;

// ���� #3052
// �� �ڿ��� A,B�� �ִ�
// �� 10���� �Է� ���� ��, 42�� ���� �������� ���Ѵ�.
// ���� �ٸ� ���� � �ִ��� ����϶�
// ù��° �ٺ��� ����° �ٱ��� ���ڰ� ���ٿ� �ϳ��� �־�����. �� ���ڴ� 1000���� �۰ų� ���� ���� �ƴ� ����


import java.io.*;
import java.util.*;

public class boj_3052 {
	public static void main(String[] args) throws IOException {
			
		//arraylist ���
		
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			ArrayList<Integer> al = new ArrayList<>();
//			
//			for(int i = 0; i < 10; i++) {
//				// int n = Integer.parseInt(br.readLine());
//				// al.add(i) = n % 42; �� �ȵǴ���.. ->    al.add(i % 42);
//				int n = Integer.parseInt(br.readLine()) % 42;
//				// arraylist�� n�� ���� ������
//				// contains() ���־���
//				if(!al.contains(n))
//					al.add(n);				
//			} 
//			
//			System.out.println(al.size());
		
		
		// hashset ���
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine()) % 42;
			hs.add(num);
		}
		
		System.out.println(hs.size());
	}
}
