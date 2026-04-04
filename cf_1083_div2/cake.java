package cf_1083_div2;
import java.util.*;
public class cake {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            List<Integer> uniqueFactors = new ArrayList<>();
            HashMap<Integer, Integer> factorCount = new HashMap<>();
            int temp = n,max_count=0,max_count_num=0;
            for(int j=2;j*j<=n;j++){
                int count=0;
                while(temp%j==0){
                    if(!factorCount.containsKey(j)){
                        uniqueFactors.add(j);
                    }
                    count++;
                    factorCount.put(j, factorCount.getOrDefault(j, 0)+1);
                    temp /= j;
                }
                if(count > max_count){
                    max_count = count;
                    max_count_num = j;
                }
            }
            if(temp != 1){
                uniqueFactors.add(temp);
                factorCount.put(temp, 1);
            }
            int ans = 1;
            for(int factor: uniqueFactors){
                ans *= factor;
            }
            if(max_count > n){
                for(int j=0;j<max_count-n;j++){
                    ans *= max_count_num;
                }
            }
            System.out.println(ans);
        }
    }
}
