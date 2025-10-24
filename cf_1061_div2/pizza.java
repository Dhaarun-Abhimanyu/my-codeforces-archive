package cf_1061_div2;
import java.util.*;
public class pizza {
    static int calc(int n){
        int ans = 0;
        while(n >=3){
            //System.out.println("check: "+n);
            int curr = (int)(n/3);
            ans += curr;
            n -= 2*curr;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            System.out.println(calc(sc.nextInt()));
        }
    }
}
