package BOJ;

/*
���� #9205 ���� ���ø鼭 �ɾ��

�Ÿ� = (��ǥx��ǥ - ����x��ǥ) + (��ǥy��ǥ - ����y��ǥ)
�ִ� ���� 20������ 1000m �̵�����

������, �佺Ƽ�� ��ǥ -> al

bfs���� �佺Ƽ�� �����ϸ� true��
-> ���� ��ǥ�� �鸮�� �ʾҰ� ���ְ� ���������� al�� ����ִ� ��ǥ q�� �߰�
 */

import java.io.*;
import java.util.*;

public class boj_9205 {
	
	static boolean[] visit;
	static ArrayList<int[]> al;
	static Queue<int[]> q;
	static boolean success;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_cnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_cnt; i++) {
			
			int shop_cnt = Integer.parseInt(br.readLine());
			
			visit = new boolean[shop_cnt + 1]; // visit�� (������ ��ǥ + �佺Ƽ�� ��ǥ) 
			al = new ArrayList<>();
			q = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int house_x = Integer.parseInt(st.nextToken());
			int house_y = Integer.parseInt(st.nextToken());
			q.offer(new int[] {house_x, house_y});
			
			for(int j = 0; j < shop_cnt+1; j++) { // ArrayList�� ������ ��ǥ + �佺Ƽ�� ��ǥ
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				al.add(new int[] {x, y});
			}
			
			success = false;
			
			bfs(shop_cnt);
			
			if(success) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int shop_cnt) {
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int now_x = now[0];
			int now_y = now[1];
			
			// �佺Ƽ���� ����������
			if(now_x == al.get(al.size() - 1)[0] && now_y == al.get(al.size() - 1)[1]) {
				success = true;
				return;
			} 
			
			for(int i = 0; i < shop_cnt + 1; i++) {
				if(!visit[i]) {
					// �Ÿ� = (��ǥx��ǥ - ����x��ǥ) + (��ǥy��ǥ - ����y��ǥ)
					// ��ǥ�� �Ÿ� ���� ���� ��������..
					int distance = Math.abs(al.get(i)[0] - now[0]) + Math.abs(al.get(i)[1] - now[1]);
					
					if(distance <= 1000) { // �� ���� 50m���µ� �ִ� 20���̸� 1000
						visit[i] = true;
						q.offer(new int[] {al.get(i)[0], al.get(i)[1]});
					}
				}
			}
		}
	}
}
