package Baekjoon;

//백준 1697번 숨바꼭질

import java.io.*;
import java.util.*;

public class Baekjoon_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[100001];
        if(N==M){
            System.out.println(0);
        }
        else{
            System.out.println(bfs(N, M, arr));
        }        
    }

    private static int bfs(int N, int M, int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        int answer = 0;
        arr[N] = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0; i<3; i++){
                int next = 0;
                if(i==0) {
                    next = now - 1;
                }
                else if(i==1){
                    next = now + 1;
                }
                else{
                    next = now * 2;
                }
                if(next == M){
                    answer = arr[now];
                    return answer;
                }
                if(next<0 || next>=arr.length || arr[next] != 0){
                    continue;
                }
                q.offer(next);
                arr[next] = arr[now] + 1;
            }
        }
        return answer;
    }
}
