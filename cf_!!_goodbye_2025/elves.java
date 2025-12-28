
import java.util.*;

public class elves {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n=sc.nextInt(), m=sc.nextInt();
            
            long arr[] = new long[n];
            HashMap<Long, Integer> map = new HashMap<>();
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                map.put(arr[j], j+1);
            }
            if(m>n/2){
                System.out.println("-1");
                continue;
            }
            Arrays.sort(arr);
            if(m==0){
                long sum = 0L;
                int max = n-1,bound=-1;
                List<int[]> ans = new ArrayList<>();
                for(int j=n-2;j>=0;j--){
                    sum += arr[j];
                    //ans.add(new int[]{map.get(arr[j]),map.get(arr[max])});
                    if(sum >= arr[max]){
                        bound = j;
                        break;
                    }
                }
                if(bound == -1){
                    System.out.println("-1");
                }else{
                    for(int j=0;j<bound;j++){
                        ans.add(new int[]{map.get(arr[j]), map.get(arr[j+1])});
                    }
                    for(int j=bound;j<n-1;j++){
                        ans.add(new int[]{map.get(arr[j]), map.get(arr[n-1])});
                    }
                    System.out.println(ans.size());
                    for(int[] j: ans){
                        System.out.println(j[0]+" "+j[1]);
                    }
                }
                /*if(n%3 != 0){
                    System.out.println("-1");
                    continue;
                }
                List<int[]> gap = new ArrayList<>();
                
                for(int j=n-1;j>=n/3;j-=2){
                    gap.add(new int[]{map.get(arr[j]),map.get(arr[j-1]),arr[j]-arr[j-1],0});
                }
                gap.sort((a,b) -> Integer.compare(a[2], b[2]));
                for(int j=0;j<n/3;j++){
                    if(arr[j] < gap.get(j)[2]){
                        System.out.println("-1");
                        continue outer;
                    }
                    gap.get(j)[3] = map.get(arr[j]);
                }
                System.out.println(n*2/3);
                for(int[] j: gap){
                    System.out.println(j[0]+" "+j[1]+"\n"+j[3]+" "+j[0]);
                }*/

            }else{
            System.out.println(n-m);
            for(int j=0;j<n-m;j++){
                System.out.println(map.get(arr[j+m])+" "+map.get(arr[j]));
            }}
            // 1 2 3 4
            /*
            HashMap<Integer, Integer> map = new HashMap<>();
            long arr[] = new long[n];
            PriorityQueue<Integer> minheap = new PriorityQueue<>((a,b) -> Long.compare(arr[a], arr[b]));
            PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> Long.compare(arr[b], arr[a]));
            
            for(int j=0;j<n;j++){
                arr[j] = sc.nextLong();
                minheap.offer(j);
                maxheap.offer(j);
                map.put(j, 1);
            }
            int count=0;
            while(!maxheap.isEmpty() && !minheap.isEmpty()){
                int attacker = maxheap.poll();
                int rip = minheap.poll();
                if(arr[rip]==)
                arr[attacker] -= arr[rip];
                arr[rip] = Long.MAX_VALUE;
                count++;
            }
            Arrays.sort(arr);
            */
        }
    }
}
