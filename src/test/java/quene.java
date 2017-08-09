/**
 * Created by cold on 2017/8/8.
 */
public class quene {

    private int N;
    private int q;
    private int count = 0;
    public quene(int N,int q){
        this.N = N;
        this.q = q;
    }
    public void exec(){
        int[] ret = new int[q+1];
        dfs(1,ret);
    }
    private void  dfs(int k,int[] ret){  //摆放第k个皇后
        if( k > q){
            count ++;
            System.out.print("第"+ count +"个：");
            for(int i = 1; i<=q;i++){
                System.out.print(ret[i]+",");
            }
            System.out.println();
        }else {
            for(int i = 1; i <= N;i++){
                ret[k] = i;
                if(check(ret,k)){
                    dfs(k+1,ret);
                }
            }
        }
    }
    private boolean check(int[] ret, int k){
//        for(int i = 2;i<=k; i++){
            for(int j = 1;j<=k-1;j++){
                if(ret[k] == ret[j] || Math.abs(ret[k]-ret[j]) == k-j) return false;
            }
//        }
        return true;
    }
    public int getCount(){
        return this.count;
    }
    public static void main(String[] args){
        quene q = new quene(8,8);
        q.exec();
        System.out.println(q.getCount());
    }
}
