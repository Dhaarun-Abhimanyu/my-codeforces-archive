package edcf_192_div2;
import java.util.*;
public class slide {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            int one = 0, two = 0, three = 0;
            boolean first = false, second = false, third = false;
            int oneInd = -1;
            int onep[] = new int[n+1], twop[] = new int[n+1], threep[] = new int[n+1];
            for(int j=0;j<n;j++){
                if(arr[j]==1){one++; onep[j+1] = 1;}
                else if(arr[j]==2){two++; twop[j+1] = 1;}
                else if(arr[j]==3){three++; threep[j+1] = 1;}
                onep[j+1] += onep[j];
                twop[j+1] += twop[j];
                threep[j+1] += threep[j];

                if(first && second){ break; }
                else if(first){
                    if(one+two >= three){
                        second = true;
                        if(j < n-1){ third = true;}
                        break;
                    }
                }else{
                    if(one >= two+three){
                        first = true;
                        oneInd = j;
                        one=0;two=0;three=0;
                    }
                }
            }
            int middle[] = new int[n];
            for(int j=0;j<n;j++){
                middle[j] = onep[j+1]+twop[j+1]-threep[j+1];
            }
            int maxMiddle[] = new int[n];
            maxMiddle[n-2] = middle[n-2];
            for(int j=n-3;j>=0;j--){
                maxMiddle[j] = Math.max(maxMiddle[j+1], middle[j]);
            }
            boolean ans = false;
            for(int j=0;j<n-2;j++){
                if(onep[j+1] >= twop[j+1]+threep[j+1]){
                    if(maxMiddle[j+1]-middle[j]>=0){
                        ans = true;
                        break;
                    }
                }
            }
            if(ans){
                System.out.println("YES");
            }else{
                System.out.println("NO");
                /* 
                one=0;two=0;three=0;
                for(int j=0;j<=oneInd;j++){
                    if(arr[j]==1){one++;}
                    else if(arr[j]==2){two++;}
                    else if(arr[j]==3){three++;}
                }
                int twoInd = -1;
                int maxDiff = Integer.MIN_VALUE;
                for(int j=oneInd+1;j<n;j++){
                    int currTwo = twop[j]-twop[j-oneInd];
                    int currOne = onep[j]-onep[j-oneInd];
                    int currThree = threep[j]-threep[j-oneInd];
                    if(currTwo+currOne-currThree >= maxDiff){
                        maxDiff = currTwo+currOne-currThree;
                        twoInd = j;
                    }
                }
                if(twoInd == n-1){twoInd--;}
                third = true;
                int ind = oneInd+1;
                if(ind < n){
                    if(arr[ind]==2){two++;}
                    if(arr[ind]==3){three++;}
                    if(arr[ind]==1){one++;}
                }
                boolean check = false;
                while(ind < n && one >= two+three){
                    if(onep[ind]-one+twop[ind]-two >= threep[ind]-three){
                        second = true;
                        check = true;
                        break;
                    }
                    ind++;
                    if(ind < n){
                        if(arr[ind]==2){two++;}
                        if(arr[ind]==3){three++;}
                        if(arr[ind]==1){one++;}
                    }
                }
                if(!check){second = false;}
                if(first && second && third){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }*/
            }
        }
    }
}
