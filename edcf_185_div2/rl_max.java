package edcf_185_div2;
import java.util.*;
public class rl_max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int max = 0, count = 0,sum=0;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                max = Math.max(max, arr[j]);
                if(arr[j] > 0){count++; }
                sum += arr[j];
            }
            int ans = 0;
            if(max >= n || sum - count >= n-1){
                ans = count;
            }else{
                ans = Math.max(1, count - ((n-1) - (sum-count)));
                
            }
            System.out.println(ans);
        }
    }
}
