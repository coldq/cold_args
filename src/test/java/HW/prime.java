package HW;

/**
 * Created by cold on 2017/8/15.
 */
import java.util.*;

public class prime{
    private static double b = 0x1.fffffffffffffp-2;
    public static void main(String[] a){
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        if(isPrime(num)){
            System.out.println(num+" ");
        }else{
            for(int i=2;i<=num;){
                if(num %i==0 && isPrime(i)){
                    num /= i;
                    System.out.print(i+" ");
                }else{
                    i++;
                }
            }
        }
    }
    private static boolean isPrime(long m){
        long q = (long)Math.sqrt(m);
        for(int i=2;i<=q;i++){
            if(m%i==0) return false;
        }
        return true;
    }
}
