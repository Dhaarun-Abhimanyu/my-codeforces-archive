package cf_1061_div2;
import java.util.*;
public class whiteboard {
/*
10: 5, 3, 2
11: 5, 4, 2
12: 6, 3, 3
 */
    static int gcd(int n, int k, int[] arr, int max){
        int prefix[] = new int[n+1];
        int count[] = new int[n+1];
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        prefix[0] = count[0];
        for(int i=1;i<=n;i++){
            prefix[i] = prefix[i-1] + count[i];
        }
        for(int i=max;i>=1;i--){
            int d4 = Math.min(n,4*i-1);
            int mult = 0;
            for(int j=i;j<=d4;j+=i){
                mult += count[j];
            }
            int rem = prefix[d4] - mult;
            if(rem <= k){
                return i;
            }
        }
        return 1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            int max = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                max = Math.max(max, arr[j]);
            }
            System.out.println(gcd(n, k, arr, max));
        }
    }
}
