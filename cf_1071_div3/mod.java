package cf_1071_div3;
import java.util.*;
public class mod {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println((Math.max(arr[0], arr[1]-arr[0])));
        }
    }
}
