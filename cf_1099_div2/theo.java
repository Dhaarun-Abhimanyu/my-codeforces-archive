package cf_1099_div2;
import java.util.*;
public class theo {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            HashMap<Integer, Integer> cost = new HashMap<>();
            HashMap<Integer, Integer> count = new HashMap<>();
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                //count.put(arr[j], count.getOrDefault(arr[j], 0)+1);
            }
            
            a:
            for(int j=0;j<n;j++){
                int curr = arr[j];
                if (curr == 1) {
                    cost.put(1, cost.getOrDefault(1, 0) + 0);
                    count.put(1, count.getOrDefault(1, 0) + 1);
                    
                    cost.put(2, cost.getOrDefault(2, 0) + 1);
                    count.put(2, count.getOrDefault(2, 0) + 1);
                    continue; 
                }
                int c = 0;
                while(true){
                    cost.put(curr, cost.getOrDefault(curr, 0)+c);
                    count.put(curr, count.getOrDefault(curr, 0)+1);
                    
                    if(curr==1){ break; }
                    if(curr%2==0){
                        curr /= 2;
                    }else{
                        curr++;
                    }
                    c++;
                }
            }
            long ans = cost.get(1);
            outer:
            for(Map.Entry<Integer, Integer> e: count.entrySet()){
                long temp = e.getValue();
                //System.out.println(temp);
                if(temp == n)
                ans = Math.min(ans, cost.get(e.getKey()));
            }
            System.out.println(ans);
        }
    }
}
