package edcf_190_div2;
import java.util.*;
public class key {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            long n = sc.nextLong(), a=sc.nextLong(), b=sc.nextLong();
            long res = 0L;
            if(3*a <= b){
                res = n*a;
            }else{
                res = (n/3)*b;
                long rem = n%3;
                res += Math.min(b, rem*a);
            }
            System.out.println(res);
        }
    }
}
