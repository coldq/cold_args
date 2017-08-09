package cold.Graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by cold on 2017/6/6.
 */
public class graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[])new Bag[V];
        for(int v = 0; v < V ;v++)adj[v] = new Bag<Integer>();
    }
    public graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }
    public  int V(){
        return V;
    }
    public int E(){
        return E;
    }

    public static int degree(graph G, int V){
        int degree = 0;
        for(int w : G.adj(V))degree++;
        return degree;
    }

    public  void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public  Iterable<Integer> adj(int v){
        return adj[v];
    }

    @Override
    public String toString(){
        String s = V + "vertice," + E +"edges\n";
        for(int v = 0;v < V; v++){
            s += v+":";
            for (int w:this.adj[v])
                s += w +"";
            s += "\n";
        }
        return s;
    }
}
