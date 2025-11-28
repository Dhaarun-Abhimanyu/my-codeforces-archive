
package edcf_185_div2;
import java.util.*;

public class matrix_cost {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int ans = 0;
            if(n==1){ans = 1; }
            else if(n==2){ans = 9;}
            else{
                ans = Math.max(4*n*n - 1 - 2 - n - 1, 5*n*n - 1 - n - 1 - n - 2 - n - 2*n -1);
            }
            System.out.println(ans);
        }
    }
}
