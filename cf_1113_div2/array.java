package cf_1113_div2;
import java.util.*;
public class array {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), m = sc.nextInt();
            int a[] = new int[n], b[] = new int[m];
            List<Integer> total = new ArrayList<>();
            HashSet<Integer> aset = new HashSet<>();
            HashSet<Integer> bset = new HashSet<>();
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
                total.add(a[j]);
                aset.add(a[j]);
            }for(int j=0;j<m;j++){
                b[j] = sc.nextInt();
                total.add(b[j]);
                bset.add(b[j]);
            }
            if(n < 2*m){
                System.out.println("NO");
                continue;
            }
            Arrays.sort(a);
            Arrays.sort(b);
            Collections.sort(total);
            int track = 0, l = 0, r = 0;
            while(l < n && r < m){
                if(a[l] < b[r]){
                    track++;
                    l++;
                }else{
                    track--;
                    r++;
                    if(track < 0){
                        System.out.println("NO");
                        continue outer;
                    }
                }
            }
            track = 0; l = n-1; r = m-1;
            while(l >= 0 && r >= 0){
                if(a[l] > b[r]){
                    track++;
                    l--;
                }else{
                    track--;
                    r--;
                    if(track < 0){
                        System.out.println("NO");
                        continue outer;
                    }
                }
            }
            System.out.println("YES");
            /*
            boolean tmp = false;
            int sp = -1,tobepop = 0;
            int count=0;
            for(int j: total){
                if(bset.contains(j)){
                    if(sp==-1){
                        System.out.println("NO");
                        continue outer;
                    }
                    tobepop++;
                    sp--;
                    tmp = true;
                    count++;
                }else{
                    if(tobepop > 0 && (!tmp || count==m || sp != -1)){
                        tobepop--;
                    }else{
                        sp++;
                    }
                    tmp = false;
                }
            }
            if(tobepop != 0){
                System.out.println("NO");
                continue outer;
            }
            System.out.println("YES");
            */
        }
    }
}
