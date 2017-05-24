/**
 * Created by cold on 2017/5/24.
 */
public class insertTest {
    public static void main(String[] args) {
        int[] a = {3,1,2,8,7,9,6,4,5,6,-1};
        myArray arr = new myArray(a);
        arr.bubbleSortAdvance();
        System.out.println(arr);
    }
}
