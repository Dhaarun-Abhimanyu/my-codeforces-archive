package cf_1098_div2;
import java.util.*;
public class reimu {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), x1 = sc.nextInt(), x2 = sc.nextInt(), k=sc.nextInt();
            if(n <= 3){ System.out.println(1); }
            else{
                System.out.println(k+Math.min(n-Math.abs(x1-x2), Math.abs(x1-x2)));
            }
        }
    }
}
