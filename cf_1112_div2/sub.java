package cf_1112_div2;
import java.util.*;
public class sub {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            List<Integer> num = new ArrayList<>();
            List<List<Integer>> lrank = new ArrayList<>();
            List<List<Integer>> rrank = new ArrayList<>();
            for(int j=0;j<n;j++){
                num.add(j+1);
                List<Integer> temp1 = new ArrayList<>();
                List<Integer> temp2 = new ArrayList<>();
                temp1.add(sc.nextInt());
                temp1.add(sc.nextInt());
                lrank.add(temp1);
                temp2.add(sc.nextInt());
                temp2.add(sc.nextInt());
                rrank.add(temp2);
                
            }
            boolean check = true;
            int ans = n;
            int size = n;

            for(int m = n; m>= 0;m--){
                int valid = 0;
                int left = 1;
                for(int j=0;j<n;j++){
                    int right = m - left + 1;
                    if(!((left >= lrank.get(j).get(0) && left <= lrank.get(j).get(1))
                        ||
                       (right >= rrank.get(j).get(0) && right <= rrank.get(j).get(1))
                    )){
                        left++;
                        valid++;
                    }
                }
                if(valid >= m){
                    System.out.println(m);
                    break;
                }
            }
            /* 
            outer:
            while(check && size != 0){
                check = false;
                int m = num.size();
                for(int j=0;j<m;j++){
                    int left = j+1, right = m - (j+1) + 1;
                    if((left >= lrank.get(j).get(0) && left <= lrank.get(j).get(1))
                        ||
                       (right >= rrank.get(j).get(0) && right <= rrank.get(j).get(1))
                    ){
                        ans--;
                        check = true;
                        num.remove(j);
                        lrank.remove(j);
                        rrank.remove(j);
                        size = num.size();
                        continue outer;
                    }
                }
            }
            System.out.println(ans);
            */
        }
    }
}
