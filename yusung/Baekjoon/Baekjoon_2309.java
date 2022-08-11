package Baekjoon;

import java.io.*;
import java.util.*;

//백준 2309번 일곱 난쟁이
//아홉난쟁이의 키가 주어졌을 때 일곱난쟁이를 찾기
//일곱난쟁이의 키의 합이 100이됨
//시간제한 2초
//아홉난쟁이의 키는 모두 다름, 가능한 정답이 여러가지인 경우에는 아무거나 출력
//아홉난쟁이의 키를 모두 더하고, 하나씩 빼면서 100이되면 정렬해서 출력하면될듯 

public class Baekjoon_2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int height[] = new int[9];
		int sum = 0;
		int height1 = 0;
		int height2 = 0;

		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		

		//sum에서 하나씩 빼면서 100이 되면 height1과, 2에 해당하는 값을 넣어줌
		for (int j = 0; j < 8; j++) {
			for (int k = j + 1; k < 9; k++) {
				if (sum - height[j] - height[k] == 100) {
					height1 = height[j];
					height2 = height[k];
				}
			}
		}
		Arrays.sort(height);		
		
		int size = height.length;
		//사이즈까지 돌면서 출력, 이때 heigt1과 해당하는 height[i]의 값이 같으면 continue
		for (int l = 0; l < size; l++) {
			if (height1 == height[l] || height2 == height[l]) {
				continue;
			}
			System.out.println(height[l]);
		}
	}
}
