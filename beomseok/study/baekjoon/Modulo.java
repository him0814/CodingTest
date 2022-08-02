package baekjoon;
//������ ���� 3052

//�� 10���� �Է¹��� ��, �̸� 42�� ���� �������� ����.
//���� �ٸ� ���� �� �� �ִ��� ���
import java.util.*;
import java.io.*;

public class Modulo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine());
			set.add( num % 42);
		}
		System.out.println(set.size());
	}
}
