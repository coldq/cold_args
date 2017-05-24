import java.util.Arrays;

/**
 *
 * Created by cold on 2017/5/23.
 */
public class myArray {
    private int[] arr;
    public myArray(int[] arr){
        this.arr = arr;
    }

    /**
     * 直接插入排序
     * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表；
     * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止；
     * 要点：设立哨兵，作为临时存储和判断数组边界之用。
    */
    public void insertSort(){
        int l = this.arr.length;
        int[] a = this.arr;
        for(int i = 1; i < l; i++){
            if(a[i] < a[i-1]){
                int j = i-2;
                int x = a[i];
                a[i] = a[i-1];
                while ( j>= 0 &&a[j] > x ){
                    a[j+1] = a[j];
                    j--;
                }
                a[j+1] = x;
            }
            System.out.println( Arrays.toString(a));
        }


    }

    /**
     * 希尔排序：增量插入排序
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序；
     * 要点：设立哨兵，作为临时存储和判断数组边界之用。
     */
    public void shellSort(){
        int[] a = this.arr;
        int dk = a.length/2;
        while (dk >= 1){
            //shellInsert
            for (int i = dk; i < a.length; i++){
                if(a[i] < a[i-dk]){
                    int j = i - 2*dk;
                    int x = a[i];
                    a[i] = a[i-dk];
                    while (j >= 0 && x < a[j] ){
                        a[j + dk] = a[j];
                        j -= dk;
                    }
                    a[j + dk] = x;
                }
            }
            dk /= 2;
        }
    }

    public int[] getArr() {
        return arr;
    }

    @Override
    public String toString() {
        return  Arrays.toString(arr);
    }


}
