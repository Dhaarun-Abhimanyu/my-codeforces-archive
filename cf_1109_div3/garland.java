package cf_1109_div3;
import java.util.*;
public class garland {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), q = sc.nextInt();
            String s = sc.next();
            char[] bin = s.toCharArray();
            int notalt[] = new int[n];
            for(int j=1;j<n;j++){
                if(bin[j]==bin[j-1]){
                    notalt[j] = 1;
                }
            }
            int prefalt[] = new int[n];
            prefalt[0] = 0;
            for(int j=1;j<n;j++){
                prefalt[j] = prefalt[j-1]+notalt[j];
            }
            for(int j=0;j<q;j++){
                int l = sc.nextInt(), r = sc.nextInt(), k = sc.nextInt();
                if(l==r){
                    System.out.println("YES");
                    continue;
                }
                int reqalt = prefalt[r-1] - prefalt[l-1];
                reqalt = (reqalt+1)/2;
                if(reqalt > k){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
            }
        }
    }
}
