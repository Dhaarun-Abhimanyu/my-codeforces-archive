package edcf_191_div2;
import java.util.*;
public class idk {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            double temp = Math.min(z, n/(x+0.0));
            System.out.println(Math.min((int)Math.ceil(n/(x+y+0.0)), (int)Math.ceil(temp+ Math.max(0, n-temp*x)/(x+10.0*y)*1.0)));
        }
    }
}
