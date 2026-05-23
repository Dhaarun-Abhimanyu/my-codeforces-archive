package spectral_cup_cf_1100_1_2;
import java.util.*;
public class idk {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            if(arr[0]==arr[n-1]){
                System.out.println(0);
                continue;
            }
            int mid = (arr[n-1]+arr[0])/2;
            int max = Math.max(arr[n-1]-mid, mid-arr[0]);
            System.out.println(max);
        }
    }
}
