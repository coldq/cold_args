package HW;

/**
 * Created by cold on 2017/8/14.
 */
import java.util.*;

public class highest{
    public static void main(String[] args){
        int N,M;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();
            in.nextLine();
            int[] data = new int[N+1];
            for(int i=1; i<=N;i++){
                data[i] = in.nextInt();
            }
            in.nextLine();
            for(int i=0;i<M;i++){
                String[] line = in.nextLine().split(" ");
                if(line[0].equals("Q")) {
                    int max = 0;
                    int lo = Integer.parseInt(line[1]),hi = Integer.parseInt(line[2]);
                    if(lo > hi){
                        int tmp = lo;lo=hi;hi=tmp;
                    }
                    for(int j=lo; j <= hi;j++){
                        if(data[j] > max) max = data[j];
                    }
                    System.out.println(max);
                }else{

                     data[Integer.parseInt(line[1])] = Integer.parseInt(line[2]);
                }
            }
        }
    }
}
