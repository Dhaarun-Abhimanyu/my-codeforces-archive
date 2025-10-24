package cf_1061_div2;
import java.util.*;
public class whiteboard {
/*
10: 5, 3, 2
11: 5, 4, 2
12: 6, 3, 3
 */
    static int gcd(int n, int k, int[] arr, int max){
        Arrays.sort(arr);
        outer:
        for(int i=max;i>=1;i--){
            int left = 0, right=n-1,ans=left;
            while(left <= right){
                int mid = (left+right)/2;
                if(arr[mid] < 4*i){
                    ans = mid;
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            if(ans+1 <= k){
                return i;
            }
            int temp=0;
            for(int j=0;j<=ans;j++){
                if(arr[j]%i != 0){
                    temp++;
                    if(temp > k){
                        continue outer;
                    }
                }
            }
            return i;
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
