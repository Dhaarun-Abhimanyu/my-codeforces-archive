package cf_1071_div3;
import java.util.*;
public class voting {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            long sum = 0L;
            String bin = sc.next();
            int p[] = new int[n];
            for(int j=0;j<n;j++){
                p[j] = sc.nextInt();
                sum += p[j];
            }
            if(sum > (long)x+y){
                System.out.println("NO");
                continue;
            }
            int a[] = new int[n];
            int b[] = new int[n];
            long suma = 0L, sumb = 0L,aspace=0L,bspace=0L;
            boolean awin = false, bwin = false;
            for(int j=0;j<n;j++){
                char c = bin.charAt(j);
                if(c=='0'){
                    a[j] = (int)Math.floor(p[j]/2.0+1);
                    b[j] = p[j] - a[j];
                    awin = true;
                    aspace += (a[j]-b[j]-1);
                }else{
                    
                    b[j] = (int)Math.floor(p[j]/2.0+1);
                    a[j] = p[j] - b[j];
                    bwin = true;
                    bspace += (b[j]-a[j]-1);
                }
                suma += a[j];
                sumb += b[j];
            }
            if(suma>x || sumb>y){
                System.out.println("NO");
                continue;
            }
            long remA = x-suma;
            long remB = y-sumb;
            if((!awin && remA < aspace) || (!bwin || remB < bspace)){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            continue;

        }
    }
}
