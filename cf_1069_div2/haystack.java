package cf_1069_div2;
import java.util.*;
public class haystack {
    static String calc(String s, String t){
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();
        int ns = s.length(), nt = t.length();
        for(int i=0;i<ns;i++){
            char c = s.charAt(i);
            maps.put(c, maps.getOrDefault(c,0)+1);
        }
        for(int i=0;i<nt;i++){
            char c = t.charAt(i);
            mapt.put(c, mapt.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character, Integer> entry: mapt.entrySet()){
            if(entry.getValue() < maps.getOrDefault(entry.getKey(),0)){
                return "Impossible";
            }
        }
        int left = 0,ind=0;
        char[] res = new char[nt];
        char temp[] = t.toCharArray();
        Arrays.sort(temp);
        t = new String(temp);
        for(int i=0;i<nt;i++){
            char ct = t.charAt(i);
            if(mapt.getOrDefault(ct,0)==0){
                continue;
            }
            if(left==ns){
                for(int j=i;j<nt;j++){
                    if(mapt.containsKey(t.charAt(j))){
                        res[ind++] = t.charAt(j);
                        mapt.put(t.charAt(j), mapt.get(t.charAt(j))-1);
                        if(mapt.get(t.charAt(j))==0){
                            mapt.remove(t.charAt(j));
                        }
                    }
                }
                break;
            }
            char cs = s.charAt(left);
            if(cs <= ct){
                res[ind++] = cs;
                maps.put(cs, maps.get(cs)-1);
                if(maps.get(cs)==0){
                    maps.remove(cs);
                }
                mapt.put(cs, mapt.get(cs)-1);
                if(mapt.get(cs)==0){
                    mapt.remove(cs);
                }
                left++;
                if(cs < ct)
                    i--;
            }else if(mapt.get(ct) > maps.getOrDefault(ct,0)){
                res[ind++] = ct;
                mapt.put(ct, mapt.get(ct)-1);
                if(mapt.get(ct)==0){
                    mapt.remove(ct);
                }
            }else{
                int idk = i;
                while(idk < nt && ct < cs){
                    if(mapt.containsKey(ct) && mapt.get(ct) > maps.getOrDefault(ct,0)){
                        res[ind++] = ct;
                        mapt.put(ct, mapt.get(ct)-1);
                        if(mapt.get(ct)==0){
                            mapt.remove(ct);
                        }
                    }
                    idk++;
                    if(idk < nt){ ct = t.charAt(idk); }
                }

                while(left < ns && cs < ct){
                    res[ind++] = cs;
                    maps.put(cs, maps.get(cs)-1);
                    if(maps.get(cs)==0){
                        maps.remove(cs);
                    }
                    mapt.put(cs, mapt.get(cs)-1);
                    if(mapt.get(cs)==0){
                        mapt.remove(cs);
                    }
                    left++;
                    if(left < ns){ cs = s.charAt(left); }
                }
                if(left < ns){
                    res[ind++] = cs;
                    maps.put(cs, maps.get(cs)-1);
                    if(maps.get(cs)==0){
                        maps.remove(cs);
                    }
                    mapt.put(cs, mapt.get(cs)-1);
                    if(mapt.get(cs)==0){
                        mapt.remove(cs);
                    }
                    left++;
                }
            }
        }
        return new String(res);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            String s = sc.next(), tx = sc.next();
            System.out.println(calc(s,tx));
        }
    }
}
