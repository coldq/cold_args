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
     * O(n^2）
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
     * O(n*log n)
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

    /**
     * 简单选择排序
     * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
     * 然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换；
     * 依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
     */
    public void selectSort(){
        int[] a = this.arr;
        int n = a.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(a[j] < a[i]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    /**
     * 交换排序-冒泡
     * @return
     */
    public void bubbleSort(){
        int[] a = this.arr;
        int n = a.length;
        for (int i = n-1;i > 0; i--){
            for(int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    /**
     *冒泡改进
     * 设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。
     * 由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可。
     */
    public void bubbleSortAdvance(){
        int[] a = this.arr;
        int n = a.length;
        int i = n-1;
        while (i > 0){
            int pos = 0;
            for(int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    pos = j;
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
            i = pos;
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
