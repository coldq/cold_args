/**
 * Created by cold on 2017/7/23.
 * 爬梯子：动态规划 ；或者 ：矩阵幂
 */
public class clamb_stars_70 {

        public int climbStairs(int n) {
            if(n < 1){
                return 0;
            }
            if(n == 1 || n == 2){
                return n;
            }
            int [][] base = {{1,1},{1,0}};
            int [][] res = matrixPower(base,n-2);
            return 2*res[0][0]+res[1][0];
        }

        public static int[][] matrixPower(int[][] base,int n){
            if(n == 1) return base;
            int [][] tmp = matrixPower(base,n/2);
            int len = base.length;
            int [][] res = new int[len][len];
            res = matrixMul(tmp,tmp);
            if(n % 2 == 1){
                res = matrixMul(base,res);
            }
            return res;
        }
        public static int[][] matrixMul(int[][] a,int[][] b){
            int len = a.length;
            int [][] res = new int[len][len];
            res[0][0] = a[0][0]*b[0][0]+a[0][1]*b[1][0];
            res[0][1] = a[0][0]*b[0][1]+a[0][1]*b[1][1];
            res[1][0] = a[1][0]*b[0][0]+a[1][1]*b[1][0];
            res[1][1] = a[1][0]*b[0][1]+a[1][1]*b[1][1];
            return res;
        }
        public static void main(String args[]){
            int [][] base = {{1,1},{1,0}};
            int [][] res = matrixPower(base,7);
            System.out.println(res);
        }
}
