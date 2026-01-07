
import java.util.*;
public class alice {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){ arr[j] = sc.nextInt(); }
            if(arr[0]==1 || arr[n-1]==1){
                System.out.println("Alice");
            }else{
                System.out.println("Bob");
            }
        }
    }
}
