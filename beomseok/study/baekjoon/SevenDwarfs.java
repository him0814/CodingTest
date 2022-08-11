package baekjoon;
//�ϰ������� ���� 2309

//�ϰ� �������� Ű�� �� 100
//Ű�� 100�� ���� �ʴ� �ڿ���
//��ȩ �������� Ű�� ��� �ٸ���, ������ ������ ���� ������ ��쿡�� �ƹ��ų� ���

import java.io.*;
import java.util.*;

public class SevenDwarfs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] sd = new int[9];
		int sum = 0;
		for(int i=0; i<sd.length; i++) {
			sd[i] = Integer.parseInt(br.readLine());
			sum += sd[i];
		}
		Arrays.sort(sd);
		int noDwarf1 = 0;
		int noDwarf2 = 0;
		for(int j=0; j<8; j++) {
			for(int k=j+1; k<9; k++) {
				if(sum - sd[j] - sd[k] == 100) {
//					sd[j] = 0;
//					sd[k] = 0;
					noDwarf1 = j;
					noDwarf2 = k;
				}
			}
		}
//		Arrays.sort(sd);
		for(int a=0; a<9; a++) {
			if(a == noDwarf1 || a == noDwarf2) {
				continue;
			}
			System.out.println(sd[a]);
		}
		
	}
}
