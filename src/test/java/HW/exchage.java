package HW;

/**
 * Created by cold on 2017/8/14.
 */
public class exchage {
    /**
     * 交换数组里n和0的位置
     *
     * @param array
     *            数组
     * @param len
     *            数组长度
     * @param n
     *            和0交换的数
     */
    // 不要修改以下函数内容
    public static void swapWithZero(int[] array, int len, int n) {
        int tmp = array[0];
        array[0] = array[n];
        array[n] = tmp;
    }
    // 不要修改以上函数内容


    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array
     *            存储有[0,n)的数组
     * @param len
     *            数组长度
     */
    public static void sort(int[] array, int len) {
        // 完成这个函数
        for(int i=len-1;i>0;i--){
            for(int j=1;j<=i;j++){
                if(array[j] > array[0]){
                    swapWithZero(array,len,j);
                }
            }
            swapWithZero(array,len,i);
        }
    }
    public static void main(String[] args){
        int[] arr = new int[]{3,2,5,9,4,7,6};
        sort(arr,7);
        System.out.println();
    }
}
