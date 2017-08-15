package PDD;



import java.util.LinkedList;
import java.util.Scanner;

public class maze{
    private static int[][] action= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    private static class Node{
        public int x;
        public int y;
        public int steps;
        public int state;
        public Node(){}
        public Node(int x,int y,int steps,int state){
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.state = state;
        }
    }
    public static void main(String[] a){
        Scanner in = new Scanner(System.in);
        int M,N;
        while (in.hasNext()){
            M = in.nextInt();
            N = in.nextInt();
            in.nextLine();
            char[][] maz=new char[M][N];
            Node start = new Node();
            for(int i=0;i<M;i++){
                String tmp = in.nextLine();
                for(int j=0;j<N;j++){
                    maz[i][j] = tmp.charAt(j);
                    if(maz[i][j] == '2') start = new Node(i,j,0,0);
                }
            }

            boolean[][][] mark = new boolean[M][N][1<<10];
            LinkedList<Node> Q = new LinkedList<Node>();
            Q.add(start);
            while (!Q.isEmpty()){
                Node head = Q.poll();
                if(maz[head.x][head.y]=='3'){
                    System.out.println(head.steps);
                    break;
                }

                for(int i=0;i<4;i++){
                    int nx = head.x + action[i][0],ny=head.y+action[i][1];
                    int state = head.state;
                    if( nx<0 || nx>=M || ny<0 || ny>=N ||maz[nx][ny]=='0')continue;
                    if(maz[nx][ny]>='a' && maz[nx][ny]<='z') state = state|(1<<(maz[nx][ny]-'a'));
                    if(maz[nx][ny]>='A' && maz[nx][ny]<='Z' && (state&(1<<(maz[nx][ny]-'A')))==0 )continue;
                    if(!mark[nx][ny][state]){
                        mark[nx][ny][state] = true;
                        Q.add(new Node(nx,ny,head.steps+1,state));
                    }
                }
            }
        }
    }
}