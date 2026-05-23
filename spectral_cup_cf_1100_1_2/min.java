package spectral_cup_cf_1100_1_2;
import java.util.*;
public class min {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int stack[] = new int[2*100000+1];
        for(int i=0;i<t;i++){
            int sp=-1;
            int n = sc.nextInt();
            int arr[] = new int[n];
            int lastneg = -1;
            int lastpos = -1;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                if(j==0 && arr[j] < 0){
                        lastneg = j;
                }
            }
            List<Integer> res = new ArrayList<>();
            for(int j=1;j<n;j++){
                if(arr[j] < 0 && arr[j-1] >= 0){
                    res.add(j);
                    if(lastneg != -1){ res.add(lastneg+1); }
                    lastneg = j;
                }else if(arr[j] < 0){
                    lastneg = j;
                }
            }
            if(arr[n-1] > 0){
                
                res.add(n);
                if(lastneg != -1){ res.add(lastneg+1); }
            }
            System.out.println(res.size());
            for(int j=0;j<res.size();j++){
                System.out.print(res.get(j)+" ");
            }
            System.out.println();
        }
    }
}
