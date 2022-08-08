package baekjoon;
//������ �׽� ���� 1449

//���������� ���� ���� ���� �ű��ϰԵ� ���� ���ʿ��� ������ŭ ������ �Ÿ��� ���� ��.(N)
//���̰� L�� �������� ���Ѱ�
//���� ���� ��, ��� �� ��ġ�� �¿� 0.5��ŭ ������ ��� ���� �ٽô� �� ��.
//�׽��̰� �ʿ��� �������� �ּ� ���� ���

import java.io.*;
import java.util.*;

public class Repairman_hangseung {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		List<Integer> pipe = new ArrayList<>(); 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			pipe.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(pipe); // ������ ��ġ�̱� ������ �񱳸� �Ϸ��� ����
			 
		int firstHole = pipe.get(0);
		int tape = firstHole - 1;
		int cnt = 1; 
		for(int p: pipe) {
			if(tape + l < p) {
				cnt++;
				tape = p - 1;
			}
		}
		System.out.println(cnt);		
	}
}
