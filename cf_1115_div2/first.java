package cf_1115_div2;
import java.util.*;
public class first {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int ans = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                ans += arr[j];
                map.put(arr[j], map.getOrDefault(arr[j],0)+1);
            }
            List<Integer> tmp = new ArrayList<>();
            for(int j: map.keySet()){
                tmp.add(map.get(j));
            }
            Collections.sort(tmp, (a,b)->Integer.compare(b,a));
            if(tmp.size()==1){
                if(tmp.get(0)==1){
                    ans = arr[0];
                }else{
                    ans = 2*arr[0];
                }
            }else{
                int diff = tmp.get(0);
                for(int j=1;j<tmp.size();j++){
                    diff -= tmp.get(j);
                }
                if(diff > 2){
                    int check = 0;
                    for(int j: map.keySet()){
                        if(map.get(j)==tmp.get(0)){
                            check = j;
                            break;
                        }
                    }
                    diff -= 2;
                    ans -= diff*check;
                }
            }
            System.out.println(ans);
        }
    }
}
