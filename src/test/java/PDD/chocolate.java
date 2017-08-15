package PDD;

/**
 * Created by cold on 2017/8/15.
 */
import java.util.Scanner;
import java.util.Arrays;
public class chocolate{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int childNum = in.nextInt();
            int[] childs = new int[childNum];
            for(int i=0;i<childNum;i++){
                childs[i] = in.nextInt();
            }
            int chacNum = in.nextInt();
            int[] chacs = new int[chacNum];
            for(int i=0;i<chacNum;i++){
                chacs[i] = in.nextInt();
            }
            int ret = 0;
            Arrays.sort(childs);
            Arrays.sort(chacs);
            int i=childNum-1,j=chacNum-1;
            while(j>=0){
                while(i>=0 &&chacs[j]<childs[i])i--;
                if(i<0)break;
                ret++;
                j--;
                i--;
            }
            System.out.println(ret);
        }
    }
}
