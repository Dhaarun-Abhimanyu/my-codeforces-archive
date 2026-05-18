package edcf_190_div2;
import java.util.*;
public class circle {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int one = 0;
            int notOne = 0;
            boolean hasEven = false;
            long total = 0L;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                if(arr[j]==1){ one++; }else{ notOne = arr[j]; }
                if(arr[j] % 2==0){ hasEven=true;}
                total += arr[j];
            }
            if(n==1 && arr[0] <= 2){
                System.out.println(0);
                continue;
            }
            if(one==0){
                System.out.println(total);
                continue;
            }if(one==n-1){
                int temp = Math.min(one, notOne/2);
                System.out.println(notOne+temp);
                continue;
            }
            long ans = 0L;
            for(int j=0;j<n;j++){
                if(arr[j] != 1){
                    ans += arr[j];
                    int temp = Math.min(one, arr[j]/2-1);
                    ans += temp;
                    one -= temp;
                }
            }
            System.out.println(ans);
        }
    }
}
