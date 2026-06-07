package cf_1102_div2;
import java.util.*;
public class twelve {
    static long oddPalin(long n){
        int len = Long.toString(n).length();
        long temp = n;
        long half = n;
        temp /= 10;
        while(temp != 0){
            half = half*10 + temp%10;
            temp/=10;
        }
        return half;
    }
    static long evenPalin(long n){
        int len = Long.toString(n).length();
        long temp = n;
        long half = n;
        while(temp != 0){
            half = half*10 + temp%10;
            temp/=10;
        }
        return half;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            long n = sc.nextLong();
            long start = 0L;
            long n1 = 0, n2 = 0;
            while(n1 <= n){
                n1 = oddPalin(start);
                n2 = evenPalin(start);
                //System.out.println(n1+" "+n2);
                if(n-n1 >= 0 && (n-n1)%12==0){
                    System.out.println(n1+" "+(n-n1));
                    continue outer;
                }if(n-n2 >= 0 && (n-n2)%12==0){
                    System.out.println(n2+" "+(n-n2));
                    continue outer;
                }
                start++;
            }
            System.out.println("-1");
        }
    }
}
