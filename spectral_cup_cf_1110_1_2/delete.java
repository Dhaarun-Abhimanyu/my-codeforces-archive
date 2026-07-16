package spectral_cup_cf_1110_1_2;
import java.util.*;
public class delete {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), c = sc.nextInt();
            long score = 0L;
            int arr[] = new int[n];
            PriorityQueue<int[]> pairs = new PriorityQueue<>( (a,b) -> {
                int mina = Math.min(a[0], a[1]);
                int minb = Math.min(b[0], b[1]);
                int maxa = Math.max(a[0], a[1]);
                int maxb = Math.max(b[0], b[1]);
                
                if(mina == minb){
                    return Integer.compare(maxa, maxb);
                }
                return Integer.compare(mina, minb);
            });
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                if(j > 0){
                    pairs.add(new int[]{Math.min(arr[j], arr[j-1]), Math.max(arr[j], arr[j-1]), j-1, j});
                }
            }
            HashSet<Integer> delete = new HashSet<>();
            while(!pairs.isEmpty()){
                int[] curr = pairs.poll();
                if(delete.contains((curr[0])) || delete.contains(curr[1])){
                    continue;
                }
                score += Math.max(
                    Math.max(curr[0], curr[1]) - (long)c,
                    curr[0]+(long)curr[1] - 2*c
                );
                arr[curr[2]] = -1000000000-1;
                arr[curr[3]] = -1000000000-1;
                int newleft = -1, newright = -1;
                int indleft = curr[2]-1, indright = curr[2]+2;
                while(indleft >= 0){
                    if(arr[indleft] != -1000000000-1){
                        newleft = indleft;
                        break;
                    }
                    indleft--;
                }while(indright < n){
                    if(arr[indright] != -1000000000-1){
                        newright = indright;
                        break;
                    }
                    indright++;
                }
                if(newleft != -1 && newright != -1){
                    pairs.offer(new int[]{Math.min(arr[newleft], arr[newright]), Math.max(arr[newleft], arr[newright]), newleft, newright});
                }
            }
            System.out.println(score);
        }
    }
}
