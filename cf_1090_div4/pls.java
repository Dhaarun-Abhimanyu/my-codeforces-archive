package cf_1090_div4;
import java.util.*;
public class pls {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int arr[] = new int[7];
            for(int j=0;j<7;j++){ arr[j] = sc.nextInt(); }
            Arrays.sort(arr);
            int sum = arr[6];
            for(int j=0;j<6;j++){ sum += -arr[j]; }
            System.out.println(sum);
        }
    }
}
