package edcf_193_div2;
import java.util.*;
public class first {
    static boolean prime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            if(prime(n+1)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
