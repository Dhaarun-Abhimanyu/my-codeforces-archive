package cf_1102_div12_orderCapital;
import java.util.*;
public class first {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                min = Math.min(min, arr[j]);
                sum += min;
            }
            System.out.println(sum);

        }
    }
}
