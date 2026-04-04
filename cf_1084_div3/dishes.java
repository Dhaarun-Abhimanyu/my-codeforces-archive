package cf_1084_div3;
import java.util.*;
public class dishes {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int max = Integer.MIN_VALUE;
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                max = Math.max(max, arr[j]);
            }
            int count=0;
            for(int j=0;j<n;j++){
                if(arr[j]==max){count++; }
            }
            System.out.println(count);
        }
    }
}
