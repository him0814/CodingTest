package BOJ;

/*
���� #2231 ������

0���� N���� �����鼭 �������� N�� ���ڸ� ã�����
������ = N+ N�� �� �ڸ����� ��
 */

import java.io.*;

public class boj_2231 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int i = 0; i < num; i++) { // 0~num���� ����
            int now = i; // 0~num
            int sum = 0; // i �� �� �ڸ� ���� ��
            
            while(true) {
                if(now == 0) { // now /= 10; �ϴٺ��� ���� 0�϶�
                    break;
                }
                sum += now % 10; // �� �ڸ� ���� ��
                now /= 10; 
            }

            if(i + sum == num) { 
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
