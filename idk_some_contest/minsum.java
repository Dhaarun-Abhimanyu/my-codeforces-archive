package idk_some_contest;
import java.util.*;
public class minsum {
    static Scanner sc = new Scanner(System.in);

    static void mins(){
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){ arr[i] = sc.nextInt(); }
        int ret = arr[0];
        int min = arr[0];
        int sub = Math.min(arr[0],arr[1]);
        int prevmin = arr[0];
        int ind0 = (arr[0]==0)?0:-1;
        for(int i=1;i<n;i++){
            if(arr[i] == 0 && ind0 == -1){
                ind0 = i;
                prevmin = min;
                break;
            }
            if(arr[i] < min){
                min = arr[i];
            }
            
            ret += min;
        }
        if(ind0 <= 1){
            
        }else{
            ret -= sub;
        }
        System.out.println(ret);
    }
    public static void main(String args[]){
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            mins();
        }
    }
}
