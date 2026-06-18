package cf_1102_div12_orderCapital;
import java.util.*;
public class duck {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int piles[] = new int[n];
            int b[] = new int[n];
            for(int j=0;j<n;j++){
                piles[j] = sc.nextInt();
            }for(int j=0;j<n;j++){
                b[j] = sc.nextInt();
            }
            long swap = 0L;
            for(int j=0;j<n;j++){
                if(piles[j] <= b[j]){ continue; }
                boolean check = true;
                for(int k=j+1;k<n;k++){
                    if(piles[k] <= b[j]){
                        check = false;
                        for(int l=k;l>j;l--){
                            int temp = piles[l];
                            piles[l] = piles[l-1];
                            piles[l-1] = temp; 
                        }
                        swap += k-j;
                        break;
                    }
                }
                if(check){
                    System.out.println("-1");
                    continue outer;
                }
            }
            System.out.println(swap);
        }
    }
}


/* 
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            int b[] = new int[n];
            for(int j=0;j<n;j++){
                piles[j] = sc.nextInt();
                map.put(piles[j], map.getOrDefault(piles[j], new ArrayList<Integer>(Arrays.asList(0))));
                map.get(piles[j]).add(j);
            }for(int j=0;j<n;j++){
                b[j] = sc.nextInt();
            }
            int sorted[] = Arrays.copyOf(piles, n);
            Arrays.sort(sorted);
            long diff = 0L;
            long swap = 0L;
            for(int j=0;j<n;j++){
                int add = b[j]-sorted[j];
                if(add < 0){
                    System.out.println("-1");
                    continue outer;
                }
                diff += add;
                int index = map.get(sorted[j]).get(0);
                int sw = Math.abs(j-map.get(sorted[j]).get(index));
                map.get(sorted[j]).set(0, index+1);
                swap += sw;
            }
            System.out.println(swap/2L);
            */