package HW;

/**
 * Created by cold on 2017/8/15.
 * java 正则测试
 */
import java.util.Scanner;
import java.util.regex.Pattern;


public class javaReg {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String line = in.nextLine();
            if(line.length()<=8) System.out.println("NG");
            else {
                boolean ret = true;
                for(int i=0;i<line.length()-2;i++){
                    String tmp = line.substring(i,i+3);
                    if(line.indexOf(line.substring(i,i+3)) != i){
                        ret = false;
                        break;

                    }
                }

                if(ret){
                    int type = 0;
                    if(Pattern.matches(".*[a-z].*",line))type++;
                    if(Pattern.matches(".*[A-Z].*",line))type++;
                    if(Pattern.matches(".*\\d.*",line))type++;
                    if(Pattern.matches(".*\\W.*",line))type++;
                    if(type < 3) ret = false;
                }
                System.out.println(ret?"OK":"NG");
            }

        }
    }
}
