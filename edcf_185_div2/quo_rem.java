package edcf_185_div2;
import java.util.*;

public class quo_rem {
    static int calc(int n, long k, int q[], int r[]){
        /*HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(r[i], map.getOrDefault(r[i], 0)+1);
        }*/
       Arrays.sort(q);
       Arrays.sort(r);
        int count = 0;
        int le = 0, ri = n-1;
        while(le < n && ri >= 0){
            long x = ((long)q[le])*(r[ri]+1) + r[ri];
            if(x <= k){
                count++;
                le++;
                ri--;
            }else{
                ri--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            long k = sc.nextLong();
            int q[] = new int[n];
            int r[] = new int[n];
            for(int j=0;j<n;j++){
                q[j] = sc.nextInt();
            }
            for(int j=0;j<n;j++){
                r[j] = sc.nextInt();
            }
            System.out.println(calc(n, k, q, r));
        }
    }
}
