package cold.sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by cold on 2017/6/1.
 */
public class Merge {
    private static int[] aux;
    public static void sort(int[] a){
        aux = new int[a.length];
        for(int k = 0; k < a.length; k++){
            aux[k] = a[k];
        }
        sort(a,0,a.length-1);
    }
    private static void sort(int[] a,int lo, int hi){
        if(lo>=hi)return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    private static void merge(int[] a,int lo ,int mid, int hi){
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
    private static boolean less(int v , int w){
        return (v < w);
    }

    private static void exch(int[] a,int i, int j){
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void show(int[] a){
        for (int i = 0; i < a.length; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
    public static boolean isSorted(int[] a){
        for(int i = 1; i < a.length; i++){
            if(less(a[i],a[i-1]))return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[] a = new int[]{7,2,1,3,1};
        Merge.sort(a);
        assert isSorted(a);
        Merge.show(a);

    }
}
