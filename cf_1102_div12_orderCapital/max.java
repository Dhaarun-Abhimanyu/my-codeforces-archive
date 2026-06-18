package cf_1102_div12_orderCapital;
import java.util.*;
public class max {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            long stack[] = new long[n+1];
            int sp = -1;
            for(int j=0;j<n;j++){
            
                if(sp > -1 && stack[sp] > arr[j]){
                    stack[sp] += arr[j];
                }else{
                    stack[++sp] = arr[j];
                }
            }
            long mx = 0L;
            for(int j=0;j<=sp;j++){
                mx = Math.max(mx, stack[sp]);
            }
            System.out.println(mx);
        }
    }
}
