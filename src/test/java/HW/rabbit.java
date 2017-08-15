package HW;

/**
 * Created by cold on 2017/8/15.
 */
import java.util.*;
public class rabbit{
    public static void main(String[] a){
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        System.out.println(getTotalCount(month));
    }
    /**
     * 统计出兔子总数。
     *
     * @param monthCount 第几个月
     * @return 兔子总数
     */
    public static int getTotalCount(int monthCount)
    {
        int[] dp = new int[monthCount+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i=4;i <= monthCount; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[monthCount];
    }
}
