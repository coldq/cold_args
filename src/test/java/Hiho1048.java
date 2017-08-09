/**
 *
 */
import java.util.*;

public class Hiho1048{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int N = in.nextInt(),M = in.nextInt();

            ArrayList<Integer> arr = new ArrayList<Integer>();
            dfs(arr,M,0);
            arr.trimToSize();
            int[][] dp = new int[N+1][1<<5];
            for(int j = 0; j < arr.size(); j++){
                dp[1][arr.get(j)] = 1;
            }
            for(int i = 2; i <=N; i++){
                for(int j = 0; j < arr.size(); j++){
                    for(int k = 0; k < arr.size(); k++){
                        if((arr.get(j) & arr.get(k))==0){
                            dp[i][arr.get(j)] += dp[i-1][arr.get(k)];
                        }
                    }
                }
            }
            int res = 0;
            for(int j = 0; j < arr.size(); j++){
                res += dp[N][arr.get(j)];
            }
            System.out.println(res);
        }

    }
    private static void dfs(ArrayList<Integer> arr, int M,int ret){
        if(M == 0) arr.add(ret);
        else {
            if(M > 1){
                dfs(arr, M-2,ret<<2);
            }
            dfs(arr, M-1, (ret<<1)+1);
        }
    }
}
