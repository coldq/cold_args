/**
 * Created by cold on 2017/8/11.
 */

import java.util.Scanner;

public class cpu
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N,sum = 0,half;
        while(in.hasNextInt()){
            N = in.nextInt();
            int[] arr = new int[N+1];
            for(int i=1; i<=N; i++){
                arr[i] = in.nextInt()/1024;
                sum += arr[i];
            }
            half = sum/2;
            int[][] dp = new int[N+1][half+1];
            for(int i=1; i<=N;i++){
                for(int j=1;j<=half; j++){
                    if( j >= arr[i]){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i]]+arr[i]);
                    }else
                        dp[i][j] =dp[i-1][j];
                }
            }
            System.out.println((sum-dp[N][half])*1024);
        }
    }
}
