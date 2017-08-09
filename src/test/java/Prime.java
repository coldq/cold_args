/**
 * Created by cold on 2017/8/9.
 */
import java.util.*;

/**
 * 素数伴侣
 * 匈牙利算法：找最大二分图
 */
public class Prime {

    public static void main(String[] args) {
        int N;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            N = in.nextInt();
            ArrayList<Integer> odd = new ArrayList<Integer>(N / 2);
            ArrayList<Integer> even = new ArrayList<Integer>(N / 2);
            int tmp;
            for (int i = 0; i < N; i++) {
                tmp = in.nextInt();
                if (tmp % 2 == 0) even.add(tmp);
                else odd.add(tmp);
            }
            boolean[][] line = new boolean[odd.size()][even.size()];

            int[] evens = new int[even.size()];
            for (int i = 0; i < evens.length; i++) {
                evens[i] = -1;
            }

            for (int i = 0; i < odd.size(); i++) {
                int o = odd.get(i);
                for (int j = 0; j < even.size(); j++) {
                    if (check(o + even.get(j))) {
                        line[i][j] = true;
                    }
                }
            }
            int ret = 0;
            for (int i = 0; i < odd.size(); i++) {
                boolean[] used = new boolean[even.size()];
                if (find(i, used, line, evens)) ret++;
            }
            System.out.println(ret);
        }
    }

    private static boolean find(int i, boolean[] used, boolean[][] line, int[] evens) {
        for (int j = 0; j < evens.length; j++) {
            if (line[i][j] && !used[j]) {
                used[j] = true;
                if (evens[j] < 0 || find(evens[j], used, line, evens)) {
                    evens[j] = i;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(int n) {
        int sqrt = (int) (Math.sqrt(n));
        for (int i = sqrt; i > 1; i--) {
            if (n % i == 0) return false;
        }
        return true;
    }
}