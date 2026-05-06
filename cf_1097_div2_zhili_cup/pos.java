package cf_1097_div2_zhili_cup;
import java.util.*;
public class pos {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            long arr[] = new long[n];
            for(int j=0;j<n;j++){ arr[j] = sc.nextLong(); }
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            if(arr[n-1] > 0){ count++; }
            for(int j=n-2;j>=0;j--){
                if(arr[j+1] > 0){ arr[j] += arr[j+1]; }
                if(arr[j] > 0){ count++; }
            }
            System.out.println(count);
        }
    }
}
