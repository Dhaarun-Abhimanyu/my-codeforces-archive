package cf_1109_div3;
import java.util.*;
public class productivity {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), m = sc.nextInt();
            int arr[] = new int[n];
            int block[] = new int[m];
            long sums[] = new long[m+1];
            int ind = 0;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }for(int j=0;j<m;j++){
                block[j] = sc.nextInt();
            }
            Arrays.sort(block);
            long temp = 0L;
            for(int j=0;j<n;j++){
                temp += arr[j];
                if(ind < m && (j+1)==block[ind]){
                    sums[ind] = temp;
                    ind++;
                    temp=0L;
                }
            }
            sums[ind] = temp;
            long ans = 0L;
            /*
            for(int j=0;j<=m;j++){
                System.out.print(sums[j]+" ");
            }
            System.out.println();*/
            for(int j=0;j<m;j++){
                ans += Math.abs(sums[j]);
            }
            ans += sums[m];
            System.out.println(ans);
        }
    }
}
