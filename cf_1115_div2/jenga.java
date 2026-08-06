package cf_1115_div2;
import java.util.*;
public class jenga {
    static void merge(int[] one, int[] two, int ret[], int m, boolean start){
        if(start){
            int ind = 0;
            for(int i: one){
                ret[ind++] = i;
            }
            return;
        }
        int i=0,j=0,count=0;
        int a = one.length, b = two.length;
        while(i < a && j < b && count < m){
            if(one[i] > two[j]){
                ret[count] = (one[i]); i++;
            }else{
                ret[count] = (two[j]); j++;
            }
            count++;
        }
        while(i < a && count < m){
            ret[count] = one[i]; i++; count++;
        }while(j < b && count < m){
            ret[count] = (two[j]); j++; count++;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] tower = new int[n][m];
            int v[] = new int[n];
            for(int j=0;j<n;j++){
                v[j] = sc.nextInt();
            }
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    tower[j][k] = sc.nextInt();
                }
                Arrays.sort(tower[j]);
                for(int k=0;k<m/2;k++){
                    int swap = tower[j][k];
                    tower[j][k] = tower[j][m-k-1];
                    tower[j][m-k-1] = swap;
                }
            }
            int ans = m;
            
            int[] prev = new int[m];
            int[] curr = new int[m];
            int minpref[] = new int[n];
            
            boolean start = true;
            minpref[0] = v[0];
            for(int j=1;j<n;j++){
                minpref[j] = Math.min(v[j], minpref[j-1]);
            }
            for(int j=n-1;j>=0;j--){
                int val = minpref[j];
                long sum = 0L;
                merge(tower[j], prev, curr, m,start);
                start = false;
                for(int k=0;k<m;k++){
                    sum += curr[k];
                    if(sum >= val){
                        ans = Math.min(ans, k+1);
                        break;
                    }
                }
                int[] temp = prev;
                prev = curr;
                curr = temp;
            }
            System.out.println(ans);
        }
    }
}
