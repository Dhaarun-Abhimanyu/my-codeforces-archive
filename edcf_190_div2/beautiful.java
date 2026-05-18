package edcf_190_div2;
import java.util.*;
public class beautiful {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            String s = sc.next();
            int n = s.length();
            int[] vis = new int[n];
            int two=0;
            int count=0;
            for(int j=n-1;j>=0;j--){
                char c = s.charAt(j);
                if(c=='2'){
                    two++;
                }else if(c=='1' || c=='3'){
                    if(two > 0){count++; two--;}
                }else{
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
