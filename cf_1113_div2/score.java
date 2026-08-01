package cf_1113_div2;
import java.util.*;
public class score {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[2*n];
            long dp[] = new long[2*n+1];
            //HashMap<Integer, int[]> map = new HashMap<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<2*n;j++){
                arr[j] = sc.nextInt();
                if(!map.containsKey(arr[j])){
                    map.put(arr[j], j);
                }
                /*
                int inp = sc.nextInt();
                if(map.containsKey(inp)){
                    int tmp[] = map.get(inp);
                    tmp[1] = j;
                    map.put(inp, tmp);
                }else{
                    int tmp[] = new int[2];
                    tmp[0] = j;
                    map.put(inp, tmp);
                }*/
            }
            for(int j=0;j<2*n;j++){
                if(map.get(arr[j])==j){
                    dp[j+1] = dp[j]+1;
                }else{
                    dp[j+1] = Math.max(dp[j]+1, dp[map.get(arr[j])]+(long)Math.pow(j-map.get(arr[j])+1, 2));
                }
            }
            /* 
            for(int j=1;j<=2*n;j++){
                System.out.print(dp[j]+" ");
            }
            System.out.println();*/
            System.out.println(dp[2*n]);
        }
    }
}
