package pinely_round_5;
import java.util.*;

public class loyalty {

    static void calc(int n, int x, int items[]){
        Arrays.sort(items);
        long bonus = 0L,sum=0L,prev=0L;
        int end=items.length-1;
        List<Integer> order = new ArrayList<>();
        for(int i=0;i<=end;i++){
            if((sum+items[end])/x > prev){
                sum += items[end];
                prev = sum/x;
                bonus += items[end];
                order.add(items[end]);
                end--;
                i--;
            }else{
                if((sum+items[i])/x > prev){
                    prev = (sum+items[i])/x;
                    bonus += items[i];
                }
                sum += items[i];
                order.add(items[i]);
            }
        }
        System.out.println(bonus);
        for(int i=0;i<n;i++){
            System.out.print(order.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), x = sc.nextInt();
            int items[] = new int[n];
            for(int j=0;j<n;j++){
                items[j] = sc.nextInt();
            }
            calc(n, x, items);
        }
    }
}
