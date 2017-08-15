import java.util.Scanner;


public class t3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x,f,d,p;
        while (in.hasNext()){
            x = in.nextInt();
            f = in.nextInt();
            d = in.nextInt();
            p = in.nextInt();
            if(d/x <= f){
                System.out.println(d/x);
            }else {
                int ret=f;
                d = d - x*f;
                ret += d /(x + p);
                System.out.println(ret);
            }
        }
    }
}
