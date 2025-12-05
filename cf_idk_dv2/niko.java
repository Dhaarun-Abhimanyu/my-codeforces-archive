package cf_idk_dv2;
import java.util.*;

public class niko {
    /*static long dp[];
    static long rec(int i, int n, int a[], int b[]){
        if(i==n+1){
            return 0;
        }else if(dp[i] != -1){
            return dp[i];
        }
        dp[i] = Math.max(dp[i-1]-a[i-1], b[i-1]-dp[i-1])+rec(i+1, n, a, b);
        return dp[i];
    }

    static long calc(int n, int a[], int b[]){
        dp = new long[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = -1;
        }
        return rec(1,n,a,b);
    }*/

    static long calc(int n, int a[], int b[]){
        long currMax = 0L, currMin = 0L;
        for(int i=0;i<n;i++){
            long v1 = currMax - a[i];
            long v2 = currMin - a[i];
            long v3 = b[i] - currMax;
            long v4 = b[i] - currMin;

            currMax = Math.max(v1, Math.max(v2, Math.max(v3,v4)));
            currMin = Math.min(v1, Math.min(v2, Math.min(v3,v4)));
        }
        return currMax;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            for(int j=0;j<n;j++){
                b[j] = sc.nextInt();
            }
            System.out.println(calc(n, a, b));
        }
    }
}
