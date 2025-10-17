package cf_1059_div3;
import java.util.*;

public class beautiful_average {
    

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), max = 0;
            for(int j=0;j<n;j++){
                max = Math.max(max, sc.nextInt());
            }
            System.out.println(max);
        }
    }
}
