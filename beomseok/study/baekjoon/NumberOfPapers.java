package baekjoon;
//백준 1780 종이의 개수

import java.io.*;
import java.util.*;

public class NumberOfPapers {
	static int[][] map;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr = new int[3];
		
		sol(0, 0, N);
 
		System.out.println(arr[0]);	
		System.out.println(arr[1]);	
		System.out.println(arr[2]);	
	}
	
	public static void sol(int x, int y, int n) {
		if(check(x, y, n)) {
			arr[map[x][y]+1]++;
		} else {    
			int length = n/3;
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					sol(x+length*i, y+length*j, length);
				}
			}
		}
	}
	
	public static boolean check(int x, int y, int n) {
		int tmp = map[x][y];
        for (int i=x; i<x+n; i++) {
            for (int j=y; j<y+n; j++) {
                if (tmp != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
	}
}
