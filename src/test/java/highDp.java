/**
 *  状态压缩，动态规划
 *  http://hihocoder.com/problemset/problem/1044
 *  样例输入
 *  5 2 1
 *  36 9 80 69 85
 *  样例输出
 *  201
 */
import java.util.Scanner;

public class highDp{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N,M,Q;
        int[][] dp = new int[1001][1<<10];
        int[] w = new int[1001];
        while( in.hasNextInt() ){
            N = in.nextInt();
            M = in.nextInt();
            Q = in.nextInt();
            for(int i =1; i <= N; i++){
                w[i] = in.nextInt();
            }
            for(int j=1; j <= N;j++){
                for(int k=0; k <(1<<M); k++){
                    int s0 = k>>1,s1 = 1<<(M-1)|(k>>1);
                    dp[j][s0] = Math.max(dp[j][s0],dp[j-1][k]);
                    if(state(s1,Q)){
                        dp[j][s1] = Math.max(dp[j][s1],dp[j-1][k]+w[j]);
                    }
                }
            }
            int res=0;
            for(int i=0; i<(1<<M); i++){
                res = Math.max(res,dp[N][i]);
            }
            System.out.println(res);
        }
    }
    public static boolean state(int M,int Q){
        int count = 0;
        while(M > 0){
            count += 1 & M;
            M = M >> 1;
        }
        return count <= Q;
    }
}
