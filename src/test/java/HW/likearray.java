package HW;

/**
 * Created by cold on 2017/8/15.
 */
import java.util.*;

public class likearray{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n,k;
        long st = System.nanoTime()/1000000L;
        n = in.nextInt();
        k = in.nextInt();
        long a = 1111;
        long b = a/n;
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=k;i++){
            dp[1][i] = 1;
        }
        for(int i=2;i<=n;i++){
            dp[i][1] = 1;
            int sum = 0;
            for(int pre=1;pre<=k;pre++){
                sum += dp[i-1][pre];
                sum %= 1000000007;
            }
            for(int j=2;j<=k;j++){
                int invildsum = 0,x=2;
                while(x*j<=k){
                    invildsum += dp[i-1][x*j];
                    invildsum %= 1000000007;
                    x++;
                }
                dp[i][j] = (sum-invildsum)%1000000007;
            }
        }
        int ret=0;
        for(int i=1;i<=k;i++){
            ret += dp[n][i];
            ret %= 1000000007;
        }
        System.out.println(System.nanoTime()/1000000L-st);
        System.out.println(ret);
    }
}
