import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by cold on 2017/5/26.
 */
public class point2D {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);

        Point2D[] pA = new Point2D[n];
        for (int i = 0; i < n; i++){
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            pA[i] = new Point2D(x,y);
            pA[i].draw();
        }
        double min = 10;
        for(int j = 0; j < n; j++){
            for (int k = j+1; k < n; k++){
                if( pA[j].distanceTo(pA[k]) < min) min = pA[j].distanceTo(pA[k]);
            }
        }
        StdOut.println(min);

    }
}
