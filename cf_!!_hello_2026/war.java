import java.util.*;

public class war {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), m=sc.nextInt(),k=sc.nextInt()-1;
            int count = 1;
            int step = 1,ind=1;
            m++;
            int max = Math.min(k,n-k-1), rem=Math.max(k,n-k-1)-max;
            for(int j=1;j<=2*max && count <= m;j++){
                count += step;
                if(count > m){ break; }
                if(ind % 2 == 0){ step++; }
                ind++;
            }
            for(int j=1;j<=rem && count <= m;j++){
                count += step;
                if(count > m){ break; }
                step++;
                ind++;
            }
            System.out.println(ind);
        }
    }
}
