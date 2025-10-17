package cf_1058_div2;
import java.util.*;
public class min_mex {
    static int mex(int n, int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(arr[i],0);
        }
        for(int i=0;i<=n;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return n+1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            System.out.println(mex(n, arr));
        }
    }
}
