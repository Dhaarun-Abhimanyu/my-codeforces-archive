import java.util.*;

public class first {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            boolean three = false;
            boolean two = false;
            boolean twotwo = false;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                if(arr[j] >= 3){ three = true; }
                if(arr[j] == 2 && two){twotwo = true;}
                else if(arr[j]==2){two = true;}
            }
            if(three || twotwo){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}