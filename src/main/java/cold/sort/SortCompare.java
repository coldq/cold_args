package cold.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by cold on 2017/6/1.
 */
public class SortCompare {
    public static double time(String alg, Double[] a){

        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sort(a);
        if(alg.equals("Merge")) Merge.sort(a);
        if(alg.equals("Quick")) Quick.sort(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg,int N, int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i=0; i< T; i++){
            for (int j = 0; j < N; j++) a[j] = StdRandom.uniform();
            total += time(alg,a);
        }
        return total;
    }
    public static void main(String args[]){

//        StdOut.println("Insertion:"+ timeRandomInput("Insertion",10000,100));
        StdOut.println("Shell:"+ timeRandomInput("Shell",1000000,100));
        StdOut.println("Merge:"+ timeRandomInput("Merge",1000000,100));
        StdOut.println("Quick:"+ timeRandomInput("Quick",1000000,100));
    }

}
