package cf_1103_div3;
import java.util.*;
public class tatar {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), k = sc.nextInt();
            
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> arr = new ArrayList<>();
            for(int j=0;j<n;j++){ 
                arr.add(sc.nextInt());
                map.put(arr.get(j), map.getOrDefault(arr.get(j), 0)+1);
            }
            Collections.sort(arr, (a,b) -> b-a);
            if(n==1){
                System.out.println("NO");
                continue;
            }
            int max = arr.get(0);
            int l=0,r=n-1,ans=0;
            List<Integer> set = new ArrayList<>();
            for(int j: map.keySet()){
                set.add(j);
            }
            Collections.sort(set, (a,b) -> b-a);
            while(l <= r){
                int mid = (l+r)/2;
                if(arr.get(mid)==max){
                    l = mid+1;
                    ans = mid;
                }else{
                    r = mid-1;
                }
            }
            inner:
            for(int idk: set){
            int maxcount = map.get(idk);
            max = idk;
            if(maxcount%2==0){
                System.out.println("YES");
                continue outer;
            }else if(maxcount%2 != 0){
                int check = -1;
                for(int j=0;j<n;j++){
                    if(arr.get(j)>=max){ continue; }
                    if(max-arr.get(j) <= k){
                        System.out.println("YES");
                        continue outer;
                    }else{
                        continue inner;
                    }
                }

            }
            }
            System.out.println("NO");
        }
    }
}
