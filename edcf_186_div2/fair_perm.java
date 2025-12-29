package edcf_186_div2;
import java.util.*;
public class fair_perm {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            
            List<Integer> dec = new ArrayList<>();
            int start = sc.nextInt();
            long res = 0L, mod = 998244353L;
            for(int j=0;j<n;j++){
                dec.add(sc.nextInt());
            }
            if(n==1){
                System.out.println(1);
                continue outer;
            }
            dec.sort((a,b) -> b-a);
            long fact[] = new long[n+1];
            fact[n] = 0L;
            fact[n-1] = 1L;
            long suffix[] = new long[n];
            suffix[n-1] = Math.max(0, dec.get(0)-dec.get(n-1)-1);
            for(int j=n-2;j>=0;j--){
                fact[j] = (((long)n-j)*fact[j+1])%mod;
                suffix[j] = suffix[j+1] + Math.max(0,dec.get(0)-dec.get(j)-1);
            }
            for(int j=0;j<n;j++){
                if(start >= suffix[j]){
                    System.out.println((fact[j+1]*(Math.min(start-suffix[j]+1,n)))%mod);
                    continue outer;
                }
            }
            System.out.println(0);
        }
    }
}