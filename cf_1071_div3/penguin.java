package cf_1071_div3;
import java.util.*;
public class penguin {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            List<Integer> res = new ArrayList<>();
            HashSet<Integer> map = new HashSet<>();
            int lim = 1 << n;
            for(int j=n;j>=0;j--){
                int ones = (1 << j)-1;
                for(int k=0;k<lim;k++){
                    if((k & ones) == ones && !map.contains(k)){
                        res.add(k);
                        map.add(k);
                    }
                }
            }
            for(int j: res){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
