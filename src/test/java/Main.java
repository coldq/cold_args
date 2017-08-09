import java.util.Scanner;
import java.lang.Math;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int i = sc.nextInt();
            System.out.println(switchToEight(i));
        }
    }
    private static int switchToEight(int num){
        int res = 0,i = 0;
        while(num > 0){
            res += (num%8)*Math.pow(10,i);
            num = num/8;
            i++;
        }
        return res;
    }

//    private static int pow(int i,int j){
//        int res = 1;
//        for(int k = 0; k < j; k++){
//            res *= i;
//        }
//        return res;
//    }
}
