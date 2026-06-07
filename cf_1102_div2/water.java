package cf_1102_div2;
import java.util.*;
public class water {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            long height[] = new long[n];
            long ans[] = new long[n];
            for(int j=0;j<n;j++){
                height[j] = sc.nextLong();
            }
            for(int curr=0;curr<n;curr++){
                int start = curr;
                long temp[] = new long[n];
                temp[start] = 0;
                /*temp[(start+1)%n] = height[start];
                temp[(start+n-1)%n] = height[(start+n-1)%n];
                ans[(start+1)%n] += height[start];
                ans[(start+n-1)%n] += height[(start+n-1)%n];*/
                long forw[] = new long[n];
                long back[] = new long[n];
                forw[start] = height[start];
                back[start] = height[start];
                for(int j=1;j<n;j++){
                    forw[(start+j)%n] = Math.max(forw[(start+j-1)%n], height[(start+j)%n]);
                }for(int j=1;j<n;j++){
                    back[(start-j+n)%n] = Math.max(back[(start-j-1+n)%n], height[(start-j+n)%n]);
                }
                start = (start+1)%n;
                forw[start] = 0;
                back[start] = 0;
                long currMax = 0L;
                for(int j=0;j<n;j++){
                    ans[(start+j)%n] += Math.min(forw[j], back[j]);
                    temp[(start+j)%n] = Math.min(forw[j], back[j]);
                }
                for(int j=0;j<n;j++){
                    System.out.print(temp[j]+" ");
                }
                System.out.println();
            }
            for(int j=0;j<n;j++){
                System.out.print(ans[j]+" ");
            }
            System.out.println();
        }
    }
}
