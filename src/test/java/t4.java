import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
public class t4 {
    public static void  main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 1000;
        int[] data = new int[n];
        for(int i=0;i<n;i++){
            data[i] = (int)(Math.random()*10000000);
        }
//        while (in.hasNext()){
//            n = in.nextInt();

//            int[] data = new int[n];
//            for(int i=0;i<n;i++){
//                data[i] = in.nextInt();
//            }
        long start=System.currentTimeMillis();// 当前时间对应的毫秒数
            LinkedList<Integer> arr = new LinkedList<Integer>();
            for(int i=1; i<=n ; i++){
                if((i&1 )== 1){
                    arr.add(data[i-1]);
                }else {
                    arr.addFirst(data[i-1]);
                }
            }
            if((n&1 )== 1){
                for(int i=arr.size()-1;i>0;i--){
                    System.out.print(arr.get(i) + " ");
                }
                System.out.println(arr.get(0));
            }else {
                for(int i =0;i<arr.size()-1;i++){
                    System.out.print(arr.get(i) + " ");
                }
                System.out.println(arr.get(arr.size()-1));
            }
        System.out.println(System.currentTimeMillis() - start + "ms");
        }
//    }
}
