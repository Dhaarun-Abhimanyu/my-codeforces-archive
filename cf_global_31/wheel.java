package cf_global_31;

import java.util.*;
public class wheel {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int l = sc.nextInt(), a=sc.nextInt(), b=sc.nextInt();
            int res = a;
            for(int j=1;j<=l;j++){
                res = Math.max(res, (a+j*b)%l);
            }
            System.out.println(res);
        }
    }
}
