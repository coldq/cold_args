import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by cold on 2017/8/12.
 */
public class bfs_mi {
    private static int[][] ac= {{0,1},{0,-1},{1,0},{-1,0}};
    private static class node{
        public int x ,y ,step,state;
        public node(){}
        public node(int x, int y,int step,int state){
            this.x = x;
            this.y = y;
            this.state = state;
            this.step = step;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int M,N;
        String tmp;
        while (in.hasNext()){
            M = in.nextInt();//行
            N = in.nextInt();//列数
            in.nextLine();
            char[][] data = new char[M][N];
            node start = new node();
            for (int i=0; i< M; i++){
                tmp = in.nextLine();
                for(int j=0; j<N;j++){
                    data[i][j] = tmp.charAt(j);
                    if(data[i][j] == '2') start = new node(i,j,0,0);
                }
            }
            LinkedList<node> queue = new LinkedList<node>();
            boolean[][][] book= new boolean[M][N][1<<10];
            queue.add(start);
            while (!queue.isEmpty()){
                node head = queue.pollFirst();
                if(data[head.x][head.y] == '3') {
                    System.out.println(head.step);
                    break;
                }
                for(int i=0;i<4; i++){
                    int nx = head.x + ac[i][0], ny = head.y + ac[i][1];
                    if(nx >= N || nx < 0 || ny >= M || ny <0 || data[nx][ny] == '0') continue;
                    int state = head.state;
                    if(data[nx][ny] >= 'a' && data[nx][ny] <='z') state = state | 1<<(data[nx][ny]-'a');
                    if(data[nx][ny] >= 'A' && data[nx][ny] <='Z' && (state & 1<<(data[nx][ny]-'A'))==0 ) continue;
                    if(!book[nx][ny][state]){
                        book[nx][ny][state] = true;
                        queue.add(new node(nx,ny,head.step+1,state));
                    }
                }
            }
        }
    }
}
