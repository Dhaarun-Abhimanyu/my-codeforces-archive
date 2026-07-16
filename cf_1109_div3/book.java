package cf_1109_div3;
import java.util.*;
public class book {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            long check = 0L, sum=0L;
            for(int j=0;j<n;j++){
                sum += arr[j];
                check += (j+1L);
                if(sum < check){
                    System.out.println("NO");
                    continue outer;
                }
            }
            System.out.println("YES");
        }
    }
}
