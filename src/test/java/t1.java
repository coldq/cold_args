import java.util.HashSet;
import java.util.Scanner;
public class t1{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String string;
        while(s.hasNext()){
            string=s.nextLine();
            int result = 0;
            HashSet set=new HashSet();
            for(int i=0;i<string.length();i++) {
                char ch = string.charAt(i);
                if (!set.contains(ch)) {
                    result++;
                    set.add(ch);
                    if (result > 2) break;
                }
            }
            System.out.println(result>2?0:result);
        }
    }
}
