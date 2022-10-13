package BOJ;

/*
���� #1018 ü���� �ٽ� ĥ�ϱ�

n x m ü������ 8x8�� �ڸ��� ����� ���� ���ؾ���
-> (n-7) x (m-7)

8x8 ���� ü������ �����
�Է� ���� ������ 8x8 ü�������� ���Ƿ� �߶� ���Ͽ� ��ĥ �ּڰ� ���ϸ��
 */

import java.io.*;
import java.util.*;

public class boj_1018 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // �Է¿����� ���� �迭
        String[] arr = new String[N];
        // 8x8 ���� ü����
        String[] wboard = new String[8];
        String[] bboard = new String[8];
        
        for(int i = 0; i < N; i++) {
        	arr[i] = br.readLine();
        }
        
        // W�� �����ϴ� ����
        for(int i = 0; i < 8; i++) {
        	if(i % 2 == 0) { // 0������ 2��°�� 4��°�� �϶�
        		wboard[i] = "WBWBWBWB";        		
        	} else {
        		wboard[i] = "BWBWBWBW";
        	}
        }
        
        // B�� �����ϴ� ����
        for(int i = 0; i < 8; i++) {
        	if(i % 2 == 0) {
        		bboard[i] = "BWBWBWBW";
        	} else {
        		bboard[i] = "WBWBWBWB";
        	}
        }
        
        // �ּڰ��� ���ϱ� ���� ( 8x8 ü���� �̹Ƿ� �ִ� ���� ��ĥ�ϴ� ���� 64���̴�)
        int min = 64;
       
        // 8x8 ���� ü���ǰ� �Է� ������ ���� �迭�� ���Ͽ� ��ĥ �ּڰ� ���ϱ�
        for(int i = 0; i < N-7; i++) {
        	for(int j = 0; j < M-7; j++) {
        		int wcount = 0;
        		int bcount = 0;
        		for(int k = 0; k < 8; k++) {
        			for(int l = 0; l < 8; l++) {
        				if(wboard[k].charAt(l) != arr[k+i].charAt(l+j)) {
        					wcount++;
        				}
        				if(bboard[k].charAt(l) != arr[k+i].charAt(l+j)) {
        					bcount++;
        				}
        			}
        		}
        		min = Math.min(min, Math.min(wcount, bcount));
        	}
        }
        System.out.println(min);
    }
}
