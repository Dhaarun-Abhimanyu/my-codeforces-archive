package cf_1109_div3;
import java.util.*;
public class sort {
    static int gcd(int a, int b){
        if(a==0){ return b; }
        return gcd(b%a, a);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int x = sc.nextInt(), y = sc.nextInt();
            int arr[] = new int[n];
            boolean isSorted = true;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                if(j>=1 && arr[j] < arr[j-1]){
                    isSorted = false;
                }
            }
            if(isSorted){
                System.out.println("YES");
                continue;
            }
            //int diff = Math.abs(x-y);
            int div = gcd(x,y);
            //boolean ok = diff != 0;
            for(int j=0;j<n;j++){
                int displace = Math.abs((j+1)-arr[j]);
                if(displace % x == 0 || displace % y == 0  || displace % div == 0){
                    continue;
                }else{
                    System.out.println("NO");
                    continue outer;
                }
            }
            System.out.println("YES");
        }
    }
}
