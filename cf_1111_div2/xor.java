package cf_1111_div2;
import java.util.*;
public class xor {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(),q=sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            int copy[] = arr.clone();
            Arrays.sort(arr);
            int ind = 0;
            for(int j=n-1;j>=0;j--){
                if(arr[j] != copy[j]){
                    ind = j;
                    break;
                }
            }
            System.out.println((int)(Math.random()*ind));
        }
    }
}
