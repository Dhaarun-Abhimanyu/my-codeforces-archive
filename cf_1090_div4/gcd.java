package cf_1090_div4;
import java.util.*;
public class gcd {
    static long check(long a, long b){
        if(a==0L){ return b; }
        return check(b%a, a);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            long curr = 1L,iter1=1L,iter2=2L;
            HashMap<Long, Integer> map = new HashMap<>();
            for(int j=0;j<n;j++){
                System.out.print(curr+" ");
                long prev = curr;
                curr = iter1*iter2;
                long gc = check(prev, curr);
                long temp = 2L;
                /* 
                if(map.containsKey(gc)){
                    curr = curr*(iter1-1);
                }
                gc = prev;
                while(map.containsKey(gc)){
                    curr = temp*curr;
                    gc = prev*temp;
                }
                    */
                map.put(gc,0);
                iter1 = iter2;
                iter2++;
                while(map.containsKey(iter2)){iter2++; }
            }
            System.out.println();
        }
    }
}
