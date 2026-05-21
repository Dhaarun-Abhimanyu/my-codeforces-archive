package cf_1099_div2;
import java.util.*;
public class inc {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            int curr = -1;
            map.put(0, 0);
            List<Integer> one = new ArrayList<>();
            List<Integer> two = new ArrayList<>();
            one.add(0);
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                if(j==0){ curr = arr[j]; }
                else{
                    if(arr[j] >= curr){
                        map.put(j, 0);
                        one.add(j);
                        curr = arr[j];
                    }
                }
            }
            int k = 0;
            for(int j=1;j<n;j++){
                k = Math.max(k, arr[j-1]-arr[j]);
            }
            boolean shift = false;
            for(int j=1;j<n;j++){

                int temp = (shift)?k:0;
                if(arr[j] >= arr[j-1]+temp){ shift = false; continue; }
                if(arr[j] + k >= arr[j-1]+temp){ shift = true; continue; }
                System.out.println("NO");
                continue outer;
            }
            System.out.println("YES");
        }
    }
}
