package cf_1067_div2;
import java.util.*;
public class split {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[2*n];
            /*int hash[] = new int[4*100000+1];
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();*/
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<2*n;j++){
                arr[j] = sc.nextInt();
                map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
            }
            int left=0,right=0,score=0;
            ArrayList<Integer> freqs = new ArrayList<>(map.values());
            Collections.sort(freqs);
            /*for(int j: map.values()){
                if(j==1){
                    score++;
                    if(left<right){left++;}
                    else{right++;}
                }else if(j>1){
                    if(j%2==0){
                        int k = j/2;
                        if(k%2==0){k--;}
                        if(left+k<=n && right-k+j<=n){
                            left+=k; right+=j-k;score+=2;
                        }else if(left-k+j<=n && right+k<=n){
                            left+=j-k; right+=k; score+=2;
                        }else{
                            left+=j/2; right+=j/2;
                        }
                    }else{
                        score++;
                    }
                }
            }*/
           for(int j: freqs){
                
                if(j%2==0){
                        int k = j/2;
                if(k%2==0){k--;}
                if(left+k <= n && right+j-k <= n && left <= right){
                    left += k;
                    right += j - k;
                    score+=2;
                }else if (left+j-k <= n && right+k<= n && right <= left) {
                    left += j - k;
                    right += k;
                    score+=2;
                }else if(left+k <= n && right+j-k <= n){
                    left += k;
                    right += j - k;
                    score+=2;
                }else if (left+j-k <= n && right+k<= n) {
                    left += j - k;
                    right += k;
                    score+=2;
                }else {
                    int lrem = n-left, rrem = n-right;
                    if(lrem+rrem==j){
                        if(lrem%2!=0){score+=2;}
                    }else if(lrem==0){
                        right += j;
                    }else if(rrem==0){
                        left += j;
                    }
                    else if(left <= right){
                        int l = n-left;
                        if(l%2==0){l--;}
                        left += l;
                        right += n-l;
                        score+=2;
                    }else{
                        int r = n-right;
                        if(r%2==0){r--;}
                        left += j-r;
                        right += r;
                        score+=2;
                    }
                }
            }else{
                score++;
            }
            }
            /*for(int j: freqs){
                if(j == 1){
                    if(left+1 <= n && (left <= right || right==n)){
                        left++;
                    }else if(right+1 <= n){
                        right++;
                    }
                    //map.remove(idk.getKey());
                    score++;
                }
                if(j>1 && j%2 != 0){
                        int k = j/2;
                if(left+k <= n && right+j-k <= n && left <= right){
                    left += k;
                    right += j - k;
                    score+=1;
                }else if (left+j-k <= n && right+k<= n && right <= left) {
                    left += j - k;
                    right += k;
                    score+=1;
                }else if(left+k <= n && right+j-k <= n){
                    left += k;
                    right += j - k;
                    score+=1;
                }else if (left+j-k <= n && right+k<= n) {
                    left += j - k;
                    right += k;
                    score+=1;
                }else {
                    if(left <= right){
                        int l = n-left;
                        left += l;
                        right += j-l;
                    }else{
                        int r = n-right;
                        left += j-r;
                        right += r;
                    }
                    score += 1;
                }
                //map.remove(idk.getKey());
                }
                
            }*/
            

            /*for(int j: odd){
                if(j==1){
                    if(left+1 <= n){
                        left++;
                        score++;
                    }else{
                        right++;
                        score++;
                    }
                    continue;
                }
                int k = j/2;
                if(left+k <= n && right+j-k <= n){
                    left += k;
                    right += j - k;
                    score++;
                }else if (left+j-k <= n && right+k<= n) {
                    left += j - k;
                    right += k;
                    score++;
                }else if(left+j <= n){
                    left += j;
                    score++;
                }else if(right+j <= n){
                    right += j;
                    score++;
                }else{

                }
            }

            for(int j: even){
                int k = j/2;
                if(k%2==0){k--;}
                if(left+k <= n && right+j-k <= n){
                    left += k;
                    right += j - k;
                    score+=2;
                }else if (left+j-k <= n && right+k<= n) {
                    left += j - k;
                    right += k;
                    score+=2;
                }else if(left+j <= n){
                    left += j;
                }else if(right+j <= n){
                    right += j;
                }else{
                    left += j/2;
                    right += j/2;
                }
            }*/

                        /*if(left+k <= n && right+hash[j]-k <= n){
                            left += k;
                            right += hash[j] - k;
                            score++;
                        }else if (left+hash[j]-k <= n && right+k<= n) {
                            left += hash[j] - k;
                            right += k;
                            score++;
                        }*/
            System.out.println(score);
        }
    }
}
