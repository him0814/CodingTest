package baekjoon;
//������ ť ���� 1966

//ť ���� �տ� �ִ� ���� �߿䵵 Ȯ��
//������ ������ �� ���� ���� ���� �߿䵵�� ���� ������ ���� �ڷ� ���ġ

//ù ��: �׽�Ʈ���̽� ��
//�׽�Ʈ���̽� ù ��: ������ ���� N(1 �� N �� 100),
//�� ��°�� ���� �ִ��� �����ִ� ���� M(0 �� M < N)
//�׽�Ʈ���̽� �ι��� ��: 1 <= N�� ������ �߿䵵 <= 9
//�߿䵵 �ߺ� ����

import java.io.*;
import java.util.*;

public class Printer_Queue {
public static void main(String[] args) throws IOException {
//   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//   int testCase = Integer.parseInt(br.readLine());
//   for (int i = 0; i < testCase; i++) {
//      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//      StringTokenizer st = new StringTokenizer(br.readLine());
//      int n = Integer.parseInt(st.nextToken()); // ������ ����
//      int m = Integer.parseInt(st.nextToken()); // ���°�� �μ�Ǿ����� �ñ��� ������ ���� queue�� ���°�� �����ִ���
//
//      int[] arr = new int[n];
//      
//      // "1" 1 9 1 1 1
//
//      // 1 9 1 1 1 "1"
//      // 9 1 1 1 "1" 1 -> 1��°�� 9�μ�
//      // 1 1 1 "1" 1 -> 2��°�� 1�μ�
//      // 1 1 "1" 1 -> 3��°�� 1�μ�
//      // 1 "1" 1 -> 4��°�� 1�μ�
//      // "1" 1 -> 5��°�� "1"�μ�
//
//      st = new StringTokenizer(br.readLine());
//      for (int j = 0; j < n; j++) {
//         int num = Integer.parseInt(st.nextToken());
//         pq.offer(num); // 9 1 1 1 1 1
//         arr[j] = num;  // 1 1 9 1 1 1
//      }
//
//      int answer = 0;
//      int idx = 0;
//      
//      while (pq.size() > 0) {
//         int target = pq.poll();
//         while (arr[idx] != target) {
//            idx++;
//            if (idx == n) {
//               idx = 0;
//            }
//         }
//         if (arr[idx] == target) {
//            answer++;
//            if (idx == m) {
//               break;
//            }
//            idx++;
//            if (idx == n) {
//               idx = 0;
//            }
//         }
//      }
//      System.out.println(answer);
//   }
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   int testCase = Integer.parseInt(br.readLine());
   for (int i = 0; i < testCase; i++) {
      Deque<Integer> dq = new ArrayDeque<>();
      Deque<Integer> idxq = new ArrayDeque<>();
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); // ������ ����
      int m = Integer.parseInt(st.nextToken()); // ���°�� �μ�Ǿ����� �ñ��� ������ ���� queue�� ���°�� �����ִ���

      st = new StringTokenizer(br.readLine());
   
      for(int j = 0; j < n; j++) {
         dq.offer(Integer.parseInt(st.nextToken()));
         idxq.offer(j);
      }
      
      int cnt = 1;
      
      // "1" 1 9 1 1 1
//      // 1 9 1 1 1 "1"
//      // 9 1 1 1 "1" 1 -> 1��°�� 9�μ�
//      // 1 1 1 "1" 1 -> 2��°�� 1�μ�
//      // 1 1 "1" 1 -> 3��°�� 1�μ�
//      // 1 "1" 1 -> 4��°�� 1�μ�
//      // "1" 1 -> 5��°�� "1"�μ�
      
      while(!dq.isEmpty()) {
         int now = Collections.max(dq);
         int target = dq.poll();
         int targetIdx = idxq.poll();
         if(now == target) {
            if(targetIdx == m) {
               System.out.print("\n" + cnt);
               break;
            }
            cnt++;
         } else {
            dq.offer(target);
            idxq.offer(targetIdx);
         }
      }
   }
}
}