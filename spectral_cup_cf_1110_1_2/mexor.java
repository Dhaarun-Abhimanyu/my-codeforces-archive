package spectral_cup_cf_1110_1_2;
import java.util.*;
public class mexor {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), k = sc.nextInt();
            if((int)Math.log(k) > (int)Math.log(n)){
                System.out.println("NO");
                continue;
            }
            if(n==1){
                if(k==0){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
                continue;
            }
            int revmex[] = new int[n];
            revmex[0] = n;
            revmex[1] = n^k;
            if(revmex[1] > n){
                System.out.println("NO");
                continue;
            }
            int perm[] = new int[n];
            perm[n-1] = revmex[1];
            perm[n-2] = 0;
            int ind = n-3;
            int count = n-1;
            while(ind >= 0){
                if(count==revmex[1]){count--; continue;}
                perm[ind--] = count;
                count--;
            }
            System.out.println("YES");
            for(int j=0;j<n;j++){
                System.out.print(perm[j]+" ");
            }
            System.out.println();
        }
    }
}
