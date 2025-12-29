package edcf_186_div2;
import java.util.*;
public class snowman {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int c[] = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }for(int j=0;j<n;j++){
                b[j] = sc.nextInt();
            }for(int j=0;j<n;j++){
                c[j] = sc.nextInt();
            }
            long first=0L, second=0L;
            outer:
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(a[k] >= b[(k+j)%n]){
                        continue outer;
                    }
                }
                first++;
            }
            outer:
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(b[k] >= c[(k+j)%n]){
                        continue outer;
                    }
                }
                second++;
            }
            //System.out.println("oo "+first+" "+second+" "+first*second*n);
            System.out.println(first*second*n);
        }
    }
}
