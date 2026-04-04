package cf_1090_div4;
import java.util.*;
public class xor {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){arr[j] = sc.nextInt(); }
            int ans = 0;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    ans = Math.max(ans, arr[j]^arr[k]);
                }
            }
            System.out.println(ans);
        }
    }
}
