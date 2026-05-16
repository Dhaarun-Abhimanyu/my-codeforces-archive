package cf_1098_div2;
import java.util.*;
public class three {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int check[] = new int[3];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                check[arr[j]%3]++;
            }
            int ans = check[0];
            int min = Math.min(check[1], check[2]);
            ans += min + (check[1]-min)/3 + (check[2]-min)/3;
            System.out.println(ans);
        }
    }
}
