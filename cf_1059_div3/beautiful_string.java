package cf_1059_div3;
import java.util.*;

public class beautiful_string {
    static boolean flag = false;
    static boolean palin(String s, int n, List<Integer> curr){
        StringBuilder idk = new StringBuilder();
        int ind=0;
        for(int i=0;i<n;i++){
            if(ind < curr.size() && i==curr.get(ind)){
                ind++; continue;
            }
            idk.append(s.charAt(i));
        }
        String st = new String(idk);
        int l = 0,  r = st.length()-1;
        while (l <= r){
            if(st.charAt(l) != st.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        //System.out.println(st);
        return true;
    }

    static void sub(int i, String s, int n, List<Integer> curr){
        if(flag){
            return;
        }
        if(i==n){
            if(curr.size() != n && palin(s,n,curr)){
                flag = true;
                System.out.println(curr.size());
                for(int j: curr){
                    System.out.print((j+1)+" ");
                }
                System.out.println();
            }
            return;
        }
        if((curr.size()==0) || (curr.size() > 0 && s.charAt(i) >= s.charAt(curr.get(curr.size()-1)))){
            curr.add(i);
            sub(i+1,s,n,curr);
            curr.remove(curr.size()-1);
        }
        sub(i+1,s,n,curr);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            String s = sc.next();
            sub(0,s,n, new ArrayList<>());
            if(!flag){
                System.out.println(-1);
            }
            flag = false;
        }
    }
}
