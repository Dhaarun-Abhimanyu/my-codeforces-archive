import java.util.*;
public class first {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int a = sc.nextInt(),b = sc.nextInt(),c = sc.nextInt();
            int max = Math.max(a,Math.max(b,c));
            int min = Math.min(a,Math.min(b,c));
            int mid = c;
            if(a!=max && a!=min){
                mid = a;
            }else if(b!=max && b!=min){
                mid = b;
            }else if(c!=max && c!=min){
                mid = c;
            }else{}
            int ans = Math.min(max-mid, mid-min);
            System.out.println(ans);
        }
    }
}