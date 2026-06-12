package cf_1103_div3;
import java.util.*;
public class game {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), k = sc.nextInt();
            String s = sc.next();
            char[] arr = s.toCharArray();
            for(int j=0;j<n-k;j++){
                if(arr[j]=='1'){
                    arr[j] = '0';
                    arr[j+k] = (arr[j+k]=='1')?'0':'1';
                }
            }
            for(int j=0;j<n;j++){
                if(arr[j]=='1'){
                    System.out.println("NO");
                    continue outer;
                }
            }
            System.out.println("YES");
        }
    }
}
