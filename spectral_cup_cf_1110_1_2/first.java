package spectral_cup_cf_1110_1_2;
import java.util.*;
public class first {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), k = sc.nextInt();
            String pig = sc.next();
            if(k > n/2){
                System.out.println("-1");
                continue;
            }
            int ans = 0;
            for(int j=0;j<k;j++){
                ans += (pig.charAt(j)=='L')?1:0;
            }for(int j=n-1;j>n-k-1;j--){
                ans += (pig.charAt(j)=='R')?1:0;
            }
            System.out.println(ans);


            /*
            int right[] = new int[n];
            int left[] = new int[n];
            for(int j=n-2;j>=0;j--){
                int temp = 0;
                if(pig.charAt(j)=='L'){ temp = 1; }
                left[j] = temp+left[j+1];
            }
            
            for(int j=1;j<n;j++){
                int temp = 0;
                if(pig.charAt(j)=='R'){ temp = 1; }
                right[j] = temp+right[j-1];
            }
            for(int j=0;j<n-1;j++){
                if(pig.charAt())
            }*/
        }
    }
}
