package cf_1090_div4;
import java.util.*;
public class perm {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[3*n];
            for(int j=0;j<n;j++){
                arr[j*3] = j+1;
            }
            int next = n+1;
            for(int j=0;j<3*n;j++){
                if(j%3==0){continue; }
                arr[j] = next++;
            }
            for(int j=0;j<3*n;j++){
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
    }
}
