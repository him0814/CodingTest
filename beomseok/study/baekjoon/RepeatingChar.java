package baekjoon;

// ���� ���ڿ� �ݺ� 2675

// S : �Է¹��� ���ڿ�
// R : ���ڸ� �ݺ��� Ƚ��
// P : ����� ���� ������� ���ڿ�
// ------�Է�------
// ù° ��: �׽�Ʈ ���̽��� ���� T(1 �� T �� 1,000)
// �� �׽�Ʈ ���̽��� �ݺ� Ƚ�� R(1 �� R �� 8), ���ڿ� S�� �������� ����
// 1 <= S�� ���� <= 20 

import java.io.*;
import java.util.*;

public class RepeatingChar {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //�׽�Ʈ���̽� �Է�
		for(int i=0; i<t; i++) { //�׽�Ʈ���̽� Ƚ��
			StringTokenizer st = new StringTokenizer(br.readLine()," "); //���� ó��
			int r = Integer.parseInt(st.nextToken()); //���� �ݺ�
			String s = st.nextToken(); //�Է� ���ڿ�
			for(int j=0; j < s.length(); j++) { //s�� ���̸�ŭ �ݺ�
				for(int k=0; k<r; k++) { // ���ڿ��� r��ŭ �ݺ�  
					System.out.print(s.charAt(j)); // �ݺ��� ���ڿ��� �ѱ��ھ��� ���ͼ� ���
				}
			}
			System.out.println();
		}
	}

}
