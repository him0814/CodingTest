package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        z(N, r, c);
        int seq = 0;
        for(int i = 1; i <= N; i++){
            if(i == 1){
                seq += arr[i];
            }
            else{
                seq += arr[i] * (int) Math.pow(4, i - 1);
            }
        }
        System.out.println(seq);
    }
    static void z(int N, int r, int c) {
        if(N == 0){
            return;
        }
        int center = (int)Math.pow(2, N - 1);
        if(r < center && c < center){
            arr[N] = 0;
            z(N - 1, r, c);
        }
        else if(r < center && c >= center){
            arr[N] = 1;
            z(N - 1, r, c - center);
        }
        else if(r >= center && c < center){
            arr[N] = 2;
            z(N - 1, r - center, c);
        }
        else if(r >= center && c >= center){
            arr[N] = 3;
            z(N - 1, r - center, c - center);
        }
    }
}
