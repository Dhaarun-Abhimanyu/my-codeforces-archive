package cf_1083_div2;
import java.util.*;
public class blog {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            List<int[]> blogs = new ArrayList<>();
            String[] blogStrings = new String[n];
            int maxLen=0;
            for(int j=0;j<n;j++){
                blogs.add(new int[sc.nextInt()]);
                char[] curr = new char[blogs.get(j).length];
                maxLen = Math.max(maxLen, blogs.get(j).length);
                for(int k=blogs.get(j).length-1;k>=0;k--){
                    blogs.get(j)[k] = sc.nextInt();
                    curr[blogs.get(j).length-1-k] = (char)(blogs.get(j)[k]+48);
                }
                blogStrings[j] = new String(curr);
            }
            List<String> order = new ArrayList<>();
            boolean vis[] = new boolean[n];
            Arrays.sort(blogStrings);
            for(int pos=0;pos<n;pos++){
                for(char c='a'; c <= 'z';c++){
                    for(int ind=0;ind < n;ind++){
                        if(!vis[ind] && pos < blogStrings[ind].length() && blogStrings[ind].charAt(pos)==c){
                            order.add(blogStrings[ind]);
                            vis[ind] = true;
                            break;
                        }
                    }
                }
            }
            LinkedList<Character> res = new LinkedList<>();
            HashMap<Character, Integer> trackIndex = new HashMap<>();
            for(String blog: blogStrings){
                for(int j=0;j<blog.length();j++){
                    char c = blog.charAt(j);
                    res.remove((Character) c);
                    res.addFirst(c);
                }
            }
            for(char c: res){
                System.out.print(c+" ");
            }
            System.out.println();
        }

    }
}
