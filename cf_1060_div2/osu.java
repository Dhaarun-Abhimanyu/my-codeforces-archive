package cf_1060_div2;
import java.util.*;
/*
4
2 2
11
6 6
100001
5 3
10000
7 2
1010101

 */
public class osu {
    static void protect(int n, int k, String s){
        int ret = 0,one=0;
        for(int right=0;right < n;right++){
            if(s.charAt(right)=='1'){
                if(one==0)
                    ret++;
                one++;
            }
            if(right-k+1 >= 0 && s.charAt(right-k+1) == '1'){
                one--;
            }
        }
        System.out.println(ret);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            protect(n,k,s);
        }
    }
}
