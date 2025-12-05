package cf_idk_dv2;
import java.util.*;
public class sleeping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), k = sc.nextInt();
            String s = sc.next();
            int curr = -1,ret=0;
            for(int j=0;j<n;j++){
                //System.out.print(curr+" ");
                if(s.charAt(j)=='1'){
                    curr = j+k;
                }else if(j > curr){
                    ret++;
                }
            }
            System.out.println(ret);
        }
    }
}
