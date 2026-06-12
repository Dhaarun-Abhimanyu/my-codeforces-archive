import java.util.*;

public class first {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int max = 0,min=1000000;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
            }
            System.out.println(max-min+1);
        }
    }
}
