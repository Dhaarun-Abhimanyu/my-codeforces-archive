package cf_1071_div3;
import java.util.*;
public class elevator {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            long sum = Math.abs(arr[n-1]-arr[n-2]), max = Math.abs(arr[1]-arr[0]);
            int ind = 1;
            if(Math.abs(arr[n-1]-arr[n-2]) > max){
                ind = n-1;
                max = Math.abs(arr[n-1]-arr[n-2]);
            }
            for(int j=1;j<n-1;j++){
                int temp = Math.abs(arr[j] - arr[j-1]);
                sum += temp;
                int check = Math.abs(arr[j]-arr[j-1]) + Math.abs(arr[j+1]-arr[j]) - Math.abs(arr[j+1] - arr[j-1]);

                if(max < check){
                    max = check;
                    ind = j;
                }
            }
            /*sum -= Math.abs(arr[ind] - arr[ind-1]);
            if(ind>=2){
                sum = sum - Math.abs(arr[ind-1] - arr[ind-2]) + Math.abs(arr[ind]-arr[ind-2]);
            }*/
            System.out.println(sum-max);
        }
    }
}
