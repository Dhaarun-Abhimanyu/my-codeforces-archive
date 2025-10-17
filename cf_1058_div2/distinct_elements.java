package cf_1058_div2;
import java.util.*;

public class distinct_elements {
    static void ele(int n, int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int curr = 2;
        int ret[] = new int[n];
        ret[0] = 1;
        map.put(1,1);
        System.out.print(ret[0]+" ");
        for(int i=1;i<n;i++){
            if(map.containsKey(arr[i] - arr[i-1])){
                ret[i] = ret[i-(arr[i] - arr[i-1])];
            }else{
                map.put(arr[i] - arr[i-1], curr);
                ret[i] = curr++;
            }
            System.out.print(ret[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            ele(n, arr);
        }
    }
}
