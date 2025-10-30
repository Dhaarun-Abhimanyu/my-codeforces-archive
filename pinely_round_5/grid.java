package pinely_round_5;
import java.util.*;
/*class idk{
    int x,y,step;
    idk(int x, int y, int step){
        this.x = x;
        this.y = y;
        this.step = step;

    }
}*/
public class grid {
    static int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static boolean check(char[][] grid, int n){
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(grid[i][j]=='#'){
                    count++;
                    if(count==3){ return true; }
                }else{
                    count=0;
                }
            }
        }for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(grid[j][i]=='#'){
                    count++;
                    if(count==3){ return true; }
                }else{
                    count=0;
                }
            }
        }
        return false;
    }
    static String calc(int n, char[][] grid){
        if(check(grid, n)){
            return "NO";
        }

        
        ArrayList<int[]> blacks = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='#'){
                    blacks.add(new int[]{i,j});
                }
            }
        }
        if(blacks.size()==0){ return "YES"; }
        for(int[] start: blacks){
            Queue<int[]> queue = new LinkedList<>();
            boolean vis[][] = new boolean[n][n];
            queue.offer(new int[]{start[0], start[1]});
            vis[start[0]][start[1]] = true;
            System.out.print(start[0]+" "+start[1]+" - ");
            while(!queue.isEmpty()){
                int[] curr = queue.poll();
                for(int[] d:dir){
                    int x = curr[0]+d[0], y = curr[1]+d[1];
                    if(x<0 || x>=n || y<0 || y>=n){continue; }
                    if(vis[x][y]){continue; }
                    if((x>=2 && vis[x-2][y] && vis[x-1][y]) || (x>=1 && x+1<n &&  vis[x-1][y] && vis[x+1][y]) || (x>=0 && x+2 < n && vis[x+1][y] && vis[x+2][y])){ continue; }
                    if((y>=2 && vis[x][y-2] && vis[x][y-1]) || (y>=1 && y+1<n &&  vis[x][y-1] && vis[x][y+1]) || (y>=0 && y+2 < n && vis[x][y+1] && vis[x][y+2])){ continue; }
                    vis[x][y] = true;
                    queue.offer(new int[]{x,y});
                }
            }
            boolean yay = true;
            for(int[] i: blacks){
                if(!vis[i[0]][i[1]]){
                    System.out.println(i[0]+" "+i[1]);
                    yay = false;
                    break;
                }
            }
            System.out.println();
            if(yay){ return "YES"; }
        }
        return "NO";
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            char[][] grid = new char[n][n];
            for(int j=0;j<n;j++){
                String line = sc.next();
                for(int k=0;k<n;k++){
                    grid[j][k] = line.charAt(k);
                }
            }
            System.out.println(calc(n, grid));
        }
    }
}
