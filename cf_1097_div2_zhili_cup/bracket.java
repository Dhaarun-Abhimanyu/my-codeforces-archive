package cf_1097_div2_zhili_cup;
import java.util.*;
public class bracket {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            String a = sc.next(), b = sc.next();
            if(a.charAt(0)== ')' || b.charAt(0)==')' || a.charAt(n-1) == '(' || b.charAt(n-1) == '('){
                System.out.println("NO");
                continue;
            }
            int sum1 = 0, sum2 = 0;
            for(int j=0;j<n;j++){
                char ac = a.charAt(j), bc = b.charAt(j);
                int a_score = (ac=='(')?1:-1;
                int b_score = (bc=='(')?1:-1;
                if(a_score == b_score){
                    sum1 += a_score;
                    sum2 += b_score;
                }else{
                    if(sum1 > sum2){
                        sum1 += Math.min(a_score, b_score);
                        sum2 += Math.max(a_score, b_score);
                    }else{
                        sum1 += Math.max(a_score, b_score);
                        sum2 += Math.min(a_score, b_score);
                    }
                }
                if(sum1 < 0 || sum2 < 0){
                    System.out.println("NO");
                    continue outer;
                }
            }
            if(sum1 != 0 || sum2 != 0){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }
    }
}
