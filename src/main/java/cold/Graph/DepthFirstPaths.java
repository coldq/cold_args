package cold.Graph;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by cold on 2017/6/6.
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(graph G, int v){
        marked[v] = true;
        for(int w:G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v))return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
