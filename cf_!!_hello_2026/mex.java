import java.util.*;

public class mex {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt(), k=sc.nextInt();
            HashSet<Integer> map = new HashSet<>();
            for(int j=0;j<n;j++){ map.add(sc.nextInt()); }
            int j = 0;
            while(map.contains(j)){j++; }
            int ans = Math.min(j,k-1);
            System.out.println(ans);
        }
    }   
}
