package cf_1083_div2;
import java.util.*;
public class blog2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            List<int[]> blogs = new ArrayList<>();
            int maxLen=0;
            for(int j=0;j<n;j++){
                blogs.add(new int[sc.nextInt()]);
                maxLen = Math.max(maxLen, blogs.get(j).length);
                for(int k=blogs.get(j).length-1;k>=0;k--){
                    blogs.get(j)[k] = sc.nextInt();
                }
            }
            Collections.sort(blogs, (a, b) -> {
                int len = Math.min(a.length, b.length);
                for(int j=0;j<len;j++){
                    if(a[j] != b[j]){
                        return Integer.compare(a[j], b[j]);
                    }
                }
                return Integer.compare(a.length, b.length);
            });
            
            LinkedList<Integer> res = new LinkedList<>();
            for(int j=blogs.size()-1;j>=0;j--){
                int[] blog = blogs.get(j);
                for(int user: blog){
                    res.remove((Integer) user);
                    res.addFirst(user);
                }
            }
            for(int j: res){
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }
}
