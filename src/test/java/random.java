/**
 * Created by cold on 2017/7/18.
 */
import java.util.Scanner;
import java.util.TreeSet;
public class random {
        public static void main(String[] args) {


            Scanner in = new Scanner(System.in);
            while(in.hasNext()) {
                TreeSet<Integer> ts = new TreeSet<Integer>();
                int b = in.nextInt();

                if (b > 0) {
                    for (int i = 0; i < b; i++) {
                        ts.add(in.nextInt());
                    }
                }


                for (Integer i : ts) {
                    System.out.println(i);
                }
            }
        }


}
