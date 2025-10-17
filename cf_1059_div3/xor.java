package cf_1059_div3;
import java.util.*;
public class xor {

    static void bin(int x, int[] xbin){
        for(int i=31;i>=0;i--){
            xbin[i] = x&1;
            x >>= 1;
        }
    }
    static int pow(int x){
        int ret = 1;
        while(ret < x){ ret <<= 1; }
        return ret;
    }
    static void check(int a, int b){
        int abin[] = new int[32];
        int bbin[] = new int[32];
        bin(a, abin);
        bin(b, bbin);
        long power = 1L << 31;
        List<Long> ret = new ArrayList<>();

        for (int i = 0; i <= 31; i++) {
            if (abin[i] != bbin[i]) {
                ret.add(power);
            }
            power >>= 1;
        }

        System.out.println(ret.size());
        for (long val : ret) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int a = sc.nextInt(), b = sc.nextInt();
            if(pow(b) > pow(a)){
                System.out.println(-1);
            }
            else if(b==a){
                System.out.println(0);
            }else{
                check(a,b);
            }
        }
    }
}
