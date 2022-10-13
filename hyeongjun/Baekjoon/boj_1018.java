package BOJ;

/*
백준 #1018 체스판 다시 칠하기

n x m 체스판을 8x8로 자르는 경우의 수를 구해야함
-> (n-7) x (m-7)

8x8 완전 체스판을 만들고
입력 받은 예제를 8x8 체스판으로 임의로 잘라 비교하여 색칠 최솟값 구하면됨
 */

import java.io.*;
import java.util.*;

public class boj_1018 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 입력예제를 담을 배열
        String[] arr = new String[N];
        // 8x8 완전 체스판
        String[] wboard = new String[8];
        String[] bboard = new String[8];
        
        for(int i = 0; i < N; i++) {
        	arr[i] = br.readLine();
        }
        
        // W로 시작하는 보드
        for(int i = 0; i < 8; i++) {
        	if(i % 2 == 0) { // 0번쨰줄 2번째줄 4번째줄 일때
        		wboard[i] = "WBWBWBWB";        		
        	} else {
        		wboard[i] = "BWBWBWBW";
        	}
        }
        
        // B로 시작하는 보드
        for(int i = 0; i < 8; i++) {
        	if(i % 2 == 0) {
        		bboard[i] = "BWBWBWBW";
        	} else {
        		bboard[i] = "WBWBWBWB";
        	}
        }
        
        // 최솟값을 비교하기 위함 ( 8x8 체스판 이므로 최대 많이 색칠하는 경우는 64번이다)
        int min = 64;
       
        // 8x8 완전 체스판과 입력 예제를 담은 배열을 비교하여 색칠 최솟값 구하기
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
