package cold.sort;

/**
 * Created by cold on 2017/6/2.
 */
public class MaxPQ<Key extends Comparable<Key>>  {
    private Key[] pq;
    private int N = 0;
    public MaxPQ(int maxN) {
        pq =  (Key[]) new Comparable[maxN+1];

    }
    private boolean isEmpty(){return N==0;}

    public int size(){return N;}

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 上浮，子节点比父节点大
     * @param k 节点
     */
    private void swim(int k){
        while (k>1 && less(k/2,k)){
            exch(k/2,k);
            k /=2;
        }
    }
    /**
     * 下沉
     */
    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if(j < N && less(j,j+1)) j++; //二叉树只有两个子节点，取大的
            if(!less(k,j))break;
            exch(k,j);
            k = j;
        }
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1,N--);
        pq[N+1] = null;//消除引用
        sink(1);
        return max;
    }

}
