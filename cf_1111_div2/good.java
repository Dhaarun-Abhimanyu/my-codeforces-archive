package cf_1111_div2;
import java.util.*;
public class good {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), k = sc.nextInt(), m = sc.nextInt();
            if(k > m){
                System.out.println("NO");
                continue;
            }
            long ret[] = new long[n];
            System.out.println("YES");
            for(int j=0;j<n;j++){
                ret[j] = 1;
            }
            ret[k-1] = m-k+1;
            for(int j=0;j<n;j++){
                System.out.print(ret[j]+" ");
            }
            System.out.println();
        }
    }
}
