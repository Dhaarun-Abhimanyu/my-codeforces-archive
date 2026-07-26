import java.util.*;
public class first {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            int maxodd = Integer.MAX_VALUE, mineven = Integer.MIN_VALUE;
            if(n%2 != 0){
                System.out.println("NO");
                continue;
            }
            for(int j=0;j<n-1;j=j+2){
                maxodd = Math.min(maxodd, arr[j]);
            }for(int j=1;j<n;j=j+2){
                mineven = Math.max(mineven, arr[j]);
            }
            /*
            if(n%2 != 0){
                if(arr[n-1] > maxodd && arr[n-1] < mineven){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else*/
            {
                if(maxodd - mineven >= 2){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}