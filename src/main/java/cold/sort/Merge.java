package cold.sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by cold on 2017/6/1.
 */
public class Merge extends sort{
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        for(int k = 0; k < a.length; k++){
            aux[k] = a[k];
        }
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo, int hi){
        if(lo>=hi)return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    private static void merge(Comparable[] a,int lo ,int mid, int hi){
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
//    private static boolean less(Comparable v , Comparable w){
//        return (v.compareTo(w) < 0);
//    }
//
//    private static void exch(Comparable[] a,int i, int j){
//        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
//    }
//
//    private static void show(Comparable[] a){
//        for (int i = 0; i < a.length; i++){
//            StdOut.print(a[i] + " ");
//        }
//        StdOut.println();
//    }
//    public static boolean isSorted(Comparable[] a){
//        for(int i = 1; i < a.length; i++){
//            if(less(a[i],a[i-1]))return false;
//        }
//        return true;
//    }

    public static void main(String[] args){
        String[] a = new String[]{"d","be","af","ad","c"};
        Merge.sort(a);
        assert isSorted(a);
        Merge.show(a);

    }
}
