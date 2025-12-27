import java.util.*;

public class yesyes {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            String s = sc.next();
            int n = s.length();
            int y=0,nn=0;
            for(int j=0;j<n;j++){
                char c = s.charAt(j);
                if(c=='Y'){y++;}
            }
            if(y >= 2){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}