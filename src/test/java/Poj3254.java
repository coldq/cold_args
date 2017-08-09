import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Poj3254
 *  动态规划，状态压缩
 */
public class Poj3254 {
    final static int mod = 100000000;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int M,N;
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.trimToSize();
        while (in.hasNextInt()){
            M = in.nextInt();
            N = in.nextInt();
            int[][] dp = new int[M+1][1<<N];
            int[] field = new int[M+1];
            for(int i=1;i<=M;i++){
                int sum = in.nextInt();
                for(int j = 1; j<N;j++){
                    sum = (sum << 1) + in.nextInt();
                }
                field[i] = sum;
            }
            for(int state =0; state < (1<<N); state++){  // 第一行符合就是1
                if(  (state & state<<1) == 0 && (field[1] | state) == field[1]) dp[1][state] = 1;
            }
            for(int i = 2; i<=M; i++){
                for(int j =0; j < (1<<N); j++){
                    if( (j & j<<1) == 0 && (j | field[i]) == field[i]){//没有相邻
                        for (int k = 0; k <(1<<N);k++){
                            if( (j&k) ==0 )dp[i][j] += dp[i-1][k];
                        }
                    }
                }
            }
            int res=0;
            for(int i=0;i<(1<<N);i++){
                res += dp[M][i];
                res %= mod;
            }
            System.out.println(res);
        }

    }

}
