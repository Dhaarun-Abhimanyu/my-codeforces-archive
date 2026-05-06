package cf_1097_div2_zhili_cup;
import java.util.*;
public class mexmax {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            int max = arr[0];
            int mex = 0;
            if(arr[0]==0){mex = 1;}
            HashMap<Integer, Integer> map = new HashMap<>();
            long ans1 = 0L;
            ans1 += max;
            ans1 += mex;
            for(int j=1;j<n;j++){
                max = Math.max(max, arr[j]);
                if(arr[j]==mex){mex++;}
                ans1 += max;
                ans1 += mex;
            }
            long ans2 = 0L;
            max = arr[n-1];
            mex = 0;
            if(arr[n-1]==0){mex=1;}
            map.put(arr[n-1], 0);
            int highest_mex = 0;
            for(int j=0;j<n;j++){
                if(highest_mex==arr[j]){highest_mex++;}
            }
            ans2 += max;
            ans2 += mex;
            for(int j=0;j<n-1;j++){
                map.put(mex,0);
                while(mex < highest_mex && map.containsKey(mex)){
                    mex++;
                }
                ans2 += max;
                ans2 += mex;
            }
            long res = Math.max(ans1, ans2);
            System.out.println(res);
        }
    }
}
