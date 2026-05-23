package cf_1097_div2_zhili_cup;
import java.util.*;
public class perm {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int M = 998244353;
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for(int j=0;j<n;j++){ a[j] = sc.nextInt(); }
            for(int j=0;j<n;j++){ b[j] = sc.nextInt(); }
            List<int[]> space = new ArrayList<>();
            for(int j=0;j<n;j++){
                space.add(new int[n]);
                for(int k=0;k<n;k++){
                    space.get(j)[k] = a[j]*b[k];
                }
            }
            for(int j=0;j<n;j++){
                Arrays.sort(space.get(j));
            }
            long count = 0L;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    
                }
            }
        }
    }
}
