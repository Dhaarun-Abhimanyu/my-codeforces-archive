package cf_1067_div2;
import java.util.*;
public class suspension {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), y = sc.nextInt(), r = sc.nextInt();
            System.out.println(Math.min(n, y/2+r));
        }
    }
}
