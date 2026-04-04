package cf_1084_div3;
import java.util.*;
public class special {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            String s = sc.next();
            char str[] = s.toCharArray();
            char stack[] = new char[n];
            int sp = -1;
            for(int j=0;j<n;j++){
                if(sp==-1){
                    stack[++sp] = str[j];
                }else if(stack[sp]==str[j]){
                    sp--;
                }else{
                    stack[++sp] = str[j];
                }
            }
            if(sp==-1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
