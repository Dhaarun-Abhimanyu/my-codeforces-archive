package edcf_186_div2;
import java.util.*;
public class newyear {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            String s = sc.next();
            if(s.contains("2026")){
                System.out.println(0);
            }else if(s.contains("2025")){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
