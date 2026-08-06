package cf_1115_div2;
import java.util.*;
public class alt {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            String bin = sc.next();
            boolean start = true;
            char[] first = new char[n];
            char[] sec = new char[n];
            int size1 = 0, size2 = 0;
            int track = 0;
            int delorno[] = {0,0,0,0};
            boolean dont = false;
            char prev = bin.charAt(0);
            if(prev=='0'){
                delorno[2]++;
            }else{
                delorno[3]++;
            }
            for(int j=1;j<n;j++){
                char c = bin.charAt(j);
                if(!dont)
                prev = bin.charAt(j-1);
                if(c==prev){
                    if(c=='0'){
                        delorno[0]++;
                    }else{
                        delorno[1]++;
                    }
                    dont = true;
                    /*
                    if(start){
                        track = ((c-48)+1)%2;
                        sec[size2++] = c;
                    }else if(c != (char)track+48){
                        
                    }*/
                }else{
                    dont = false;
                    if(c=='0'){
                        delorno[2]++;
                    }else{
                        delorno[3]++;
                    }
                }
            }
            //System.out.println(delorno[0]+" "+delorno[1]+" "+delorno[2]+" "+delorno[3]+" ");
            if(Math.abs(delorno[0]+delorno[2]-(delorno[1]+delorno[3])) > 2){
                System.out.println("-1");
                continue;
            }
            int ans = delorno[0]+delorno[1];
            if(Math.abs(delorno[0]-delorno[1]) >= 2){
                ans += Math.abs(delorno[0]-delorno[1]) - 1;
            }
            //ans = Math.min(ans, n-ans);
            System.out.println(ans);
        }
    }
}
