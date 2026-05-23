package spectral_cup_cf_1100_1_2;
import java.util.*;
public class max {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int amax = 0, bmax = 0;
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            for(int j=0;j<n;j++){
                b[j] = sc.nextInt();
                if(a[j] > a[amax]){
                    amax = j;
                }if(b[j] > b[bmax]){
                    bmax = j;
                }
            }
            boolean check = false;
            long sum = 0L;
            long max = 0L;
            for(int j=0;j<n;j++){
                sum += Math.max(a[j], b[j]);
                max = Math.max(max, Math.min(a[j], b[j]));
            }
            System.out.println(sum+max);
        }
    }
}
