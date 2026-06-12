package cf_1103_div3;
import java.util.*;
public class idk {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            boolean valid[][] = new boolean[n][n];
            int max[][] = new int[n][n];
            int min[][] = new int[n][n];
            for(int j=0;j<n;j++){
                int mx = arr[j];
                for(int k=j;k<n;k++){
                    mx = Math.max(arr[k], mx);
                    max[j][k] = mx;
                }
            }for(int j=0;j<n;j++){
                int mn = arr[j];
                for(int k=j;k<n;k++){
                    mn = Math.min(arr[k], mn);
                    min[j][k] = mn;
                }
            }
            bruh:
            for(int j=0;j<n;j++){
                HashSet<Integer> dupe = new HashSet<>();
                for(int k=j+1;k<n;k+=2){
                    if(dupe.contains(arr[k]) || dupe.contains(arr[k-1]) || arr[k]==arr[k-1]){
                        continue bruh;
                    }
                    dupe.add(arr[k]);
                    dupe.add(arr[k-1]);
                    if(max[j][k] - min[j][k] == j-k)
                        valid[j][k] = true;
                }
            }
            int ans = 0;
            /* 
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(valid[j][k]){
                        if(max[j][k]-min[j][k] == k-j && max[j][(j+k)/2] - min[j][(j+k)/2] == (j+k)/2-j && max[(j+k)/2+1][k] - min[(j+k)/2+1][k] == k-((j+k)/2+1)){
                            ans = Math.max(ans, (k-j+1)/2);
                        }
                    }
                }
            }*/
            System.out.println(ans);
        }
    }
}
