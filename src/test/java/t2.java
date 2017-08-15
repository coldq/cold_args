import java.util.Scanner;
public class t2 {
    public static void main(String[] args ){
        Scanner in = new Scanner(System.in);
        String str ;
        while (in.hasNext()){
            str = in.nextLine();
            int ret = 1,max = 1;
            for(int i=1; i< str.length(); i++){
                if(str.charAt(i) != str.charAt(i-1)){
                    ret++;
                    max = Math.max(ret,max);
                }else{
                    ret = 1;
                }
            }
            System.out.println(max);
        }
    }
}
