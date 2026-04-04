package cf_1084_div3;
import java.util.*;
public class deletion {
    static int n;
    static int dp[][];
    
    static int rec(int arr[], int i, int j){
        if(i==n || j+1==n){return 0; }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int take = 0;
        if(arr[j+1] >= arr[i]){
            take = 1+rec(arr, j+1, j+1);
        }
        dp[i][j] = Math.max(take, rec(arr,i,j+1));
        return dp[i][j];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            n = sc.nextInt();
            int arr[] = new int[n];
            boolean flag = false;
            arr[0] = sc.nextInt();
            for(int j=1;j<n;j++){
                arr[j] = sc.nextInt();
                if(arr[j] < arr[j-1]){
                    flag = true;
                }
            }
            if(flag){
                System.out.println(1);
            }else{
                System.out.println(n);
            }
            /*
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[j][k] = -1;
                }
            }
            int ans = n;
            for(int j=0;j<n;j++){
                ans = Math.min(ans, n-rec(arr,j,j));
            }
            System.out.println(ans);*/
        }
    }
}
