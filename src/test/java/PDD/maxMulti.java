package PDD;

/**
 * Created by cold on 2017/8/15.
 */

    import java.util.*;

    public class maxMulti {
        public static void main(String[] ar){
            long max1 = 0,max2 = 0,max3 = 0,min = 0,min2 = 0;
            Scanner in = new Scanner(System.in);
            while(in.hasNextInt()){
                int N = in.nextInt();
                while(N-- > 0){
                    int tmp = in.nextInt();
                    if(tmp>max1){
                        max3 = max2;
                        max2 = max1;
                        max1 = tmp;
                    }
                    else if(tmp>max2){
                        max3 = max2;
                        max2 = tmp;
                    }else if(tmp>max1){
                        max1 = tmp;
                    }else if(tmp < min){
                        min2 = min;
                        min = tmp;
                    }else if(tmp < min2){
                        min2 = tmp;
                    }
                }
                System.out.println(max1*max2*max3>max1*min*min2 ? max1*max2*max3:max1*min*min2);
            }

        }
    }

