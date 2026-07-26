package cf_1112_div2;
import java.util.*;
public class bin {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), k=sc.nextInt();
            int ans[] = new int[n];
            if(n-k < 2){
                System.out.println("-1");
                continue;
            }if(k==1){
                ans[0] = 1;
                ans[1] = 0; ans[2] = 0;
                int temp = 1;
                for(int j=3;j<n;j++){
                    ans[j] = temp; temp = (temp+1)%2;
                }for(int j=0;j<n;j++){
                System.out.print(ans[j]);
            }
            System.out.println();
            continue;
            }
            int z = (int)Math.ceil(k/2.0), one = k-z;
            if(n%2==0){
                int temp = z;
                z = one;
                one = temp;
            }
            z++;one++;
            
            int temp = 0;
            for(int j=0;j<z;j++){ ans[j] = 0; }
            for(int j=z;j<z+one;j++){ ans[j] = 1; }
            for(int j=z+one;j<n;j++){ ans[j] = temp; temp = (temp+1)%2; }
            for(int j=0;j<n;j++){
                System.out.print(ans[j]);
            }
            System.out.println();
        }
    }
}
