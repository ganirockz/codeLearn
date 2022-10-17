package learn;
import java.util.*;

public class HelloWorld {

	public static void main(String[] args) {
		//POTD - GFG
		int[] arr = {1,3,5,6,7,4,2};
		int n = arr.length;
		long start_time = System.nanoTime();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=0;i<n;i++) {
			//int[] array = new int[n];
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			for(int j=i+1;j<n;j++) {
				int l= arr[j]-arr[i];
				if(l>0 && l<min) {
					min = l;
					index = j;
					if(l == 1)
						break;
				}
			}
			
			
			
//			for(int k=i+1;k<n;k++) {
//				if(array[k] > 0 && array[k] < min) {
//					min = array[k];
//					index = k;
//				}
//			}
			
			if(index> 0) {				
			    list.add(i,arr[index]);
			}else {
			    list.add(i,-1);
			}
			
		}
		
        
		//ArrayList<Integer> list = findLeastGreaterOne(n, arr);
		System.out.println(list);
		
		long end_time = System.nanoTime();
		
		long duration = (end_time - start_time);
		
		duration = duration/10000;
		
		System.out.println("Total Duration: "+ duration+"ms");
		
		
		
	}
	
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	

    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        TreeSet<Integer> s=new TreeSet<>();
        for(int i=n-1;i>=0;i--)
        {
            s.add(arr[i]);
            if(s.higher(arr[i])==null)
                ans.add(-1);
            else
                ans.add(s.higher(arr[i]));
        }
        Collections.reverse(ans);
        return ans;
    }
    
    public static ArrayList<Integer> findLeastGreaterOne(int n, int[] arr) {
        // code here
        int[] visited = new int[100001];
        int[] sortedarr = Arrays.copyOf(arr , n);
        for(int i = 0 ; i < n ; i++){
            visited[arr[i]]++;
        }
        ArrayList<Integer> arrlist = new ArrayList<>();
        Arrays.sort(sortedarr);
        l:
        for(int i = 0 ; i < n ;i ++){
            visited[arr[i]]--;
            int a = arr[i];
            int index = Arrays.binarySearch(sortedarr , a);
            while(index < n-1 && sortedarr[index] == sortedarr[index +1]){index++;}
            if(index == n-1){arrlist.add(-1);continue l;}
            index++;
            while(index < n){
                if(visited[sortedarr[index]] <= 0 ){index++;}

                else{
                    break;
                }
            }
            if(index == n ){arrlist.add(-1);}
            else {
                arrlist.add(sortedarr[index]);
            }
        }

        return arrlist;
    }
        
}
