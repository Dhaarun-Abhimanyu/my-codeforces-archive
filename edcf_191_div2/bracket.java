package edcf_191_div2;
import java.util.*;
public class bracket {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            char arr[] = s.toCharArray();
            int score[] = new int[n];
            int ans[] = new int[n];
            List<int[]> temp = new ArrayList<>();
            int sp = -1;
            int open[] = new int[n+2];
            int close[] = new int[n+2];
            for(int j=0;j<n;j++){
                if(arr[j]=='('){open[j] = 1;}
                else{ close[j] = 1;}
            }
            for(int j=1;j<n;j++){
                open[j] += open[j-1];
            }for(int j=n-2;j>=0;j--){
                close[j] += close[j+1];
            }for(int j=0;j<n;j++){
                if(arr[j]=='(' && j<n-1){
                    score[j] = 2*Math.min(open[j], close[j+1]);
                }else if(arr[j]==')' && j>0){
                    score[j] = 2*Math.min(open[j-1], close[j]);
                }
            }
            for(int j=0;j<n;j++){
                temp.add(new int[]{j, score[j]});
            }
            Collections.sort(temp, (a,b) -> b[1]-a[1]);
            if(temp.get(0)[1]==0){
                for(int j=0;j<n;j++){
                    System.out.print("0");
                }
                System.out.println();
                continue;
            }
            for(int j=0;j<k;j++){
                ans[temp.get(j)[0]] = 1;
            }
            for(int j=0;j<n;j++){
                System.out.print(ans[j]);
            }
            System.out.println();
        }
    }
}
