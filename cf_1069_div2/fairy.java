package cf_1069_div2;
import java.util.*;
public class fairy {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), count=0;
            int a[] = new int[n];
            HashSet<Integer> map = new HashSet<>();
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
                if(!map.contains(a[j])){
                    map.add(a[j]);
                    count++;
                }
            }
            int res = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(a[j] >= count){
                    res = Math.min(res, a[j]);
                }
            }
            System.out.println(res);
        }
    }
}
