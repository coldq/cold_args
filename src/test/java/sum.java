/**
 * Created by cold on 2017/8/1.
 */
public class sum {

        /**
         * @param num1 a non-negative integers
         * @param num2 a non-negative integers
         * @return return sum of num1 and num2
         */
        public static String addStrings(String num1, String num2) {
            // Write your code here
            int i = num1.length()-1, j =  num2.length()-1, q = 0;
            StringBuffer s = new StringBuffer();
            while (i>=0 && j>=0){
                int a = num1.charAt(i) - 48,
                        b = num2.charAt(j) - 48;
                if (q + a + b > 9) {
                    s.append( (a + b + q) % 10 );
                    q = 1;
                } else {
                    s.append( a + b );
                    q = 0;
                }
                i--;
                j--;
            }
            while (i >= 0){
                int a = num1.charAt(i--) - 48;
                if(q+a >9){
                    s.append( (a + q) % 10 );
                    q = 1;
                }
                else {
                    s.append(a+q);
                    q = 0;
                };
            }
            while (j >= 0){
                int a = num2.charAt(j--) - 48;
                if(q+a >9){
                    s.append( (a + q) % 10 );
                    q = 1;
                }
                else {
                    s.append(a+q);
                    q = 0;
                };
            }
            if(q == 1)s.append(q);
            s.reverse();
            return s.toString();
        }
    public static void main(String args[]){
        String  a = addStrings("187182781728", "1298912891289189189898198291");
        System.out.println(a);
    }
}
