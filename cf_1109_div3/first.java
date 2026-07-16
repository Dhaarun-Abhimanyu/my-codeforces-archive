package cf_1109_div3;
import java.util.*;
public class first {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            String s = sc.next();
            int max = 0;
            int curr = 0;
            for(int j=0;j<n;j++){
                char c = s.charAt(j);
                if(c=='#'){ curr++; }
                else{
                    max = Math.max(max,curr);
                    curr=0;
                }
            }
            max = Math.max(max,curr);
            System.out.println((int)Math.ceil(max/2.0));
        }
    }
}
