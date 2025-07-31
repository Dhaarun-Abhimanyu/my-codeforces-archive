package idk_some_contest;
import java.util.*;

public class derangement {
    static Scanner sc = new Scanner(System.in);
    static void der(){
        int n = sc.nextInt();
        int in[] = new int[n];
        HashMap<Integer, Integer> same = new HashMap<>();
        for(int i=0;i<n;i++){
            in[i] = sc.nextInt();
        }
        int asc[] = in.clone();
        Arrays.sort(asc);
        for(int i=0;i<n;i++){
            if(in[i] == asc[i]){same.put(i,0); }
        }
        if(same.size() >= n-1){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            System.out.println(n - same.size());
            for(int i=0;i<n;i++){
                if(!same.containsKey(i)){
                    System.out.print(in[i]+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            der();
        }
    }
}
