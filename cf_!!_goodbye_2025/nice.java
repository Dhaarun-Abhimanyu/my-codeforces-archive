import java.util.*;

public class nice {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            long arr[] = new long[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextLong();
            }
            long dp[] = new long[n];
            long pre[] = new long[n+1];
            pre[n] = 0;
            for(int j=n-1;j>=0;j--){
                pre[j] = pre[j+1]+arr[j];
            }
            dp[n-1] = 0;
            long max = pre[n-1]+dp[n-1];
            for(int j=n-2;j>=0;j--){
                long take = arr[j] + max - pre[j+1];
                long dont = -pre[j+1];
                dp[j] = Math.max(take, dont);
                max = Math.max(max, pre[j]+dp[j]);
            }
            System.out.println(dp[0]);
        }
    }
}
