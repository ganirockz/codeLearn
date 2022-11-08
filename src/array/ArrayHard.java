package array;
import java.util.*;

public class ArrayHard {
	
	// 1) All Edge Nodes have 1s.
	// 2) Remaining Nodes follow matrix[i][j] = matrix[i-1][j-1]+matrix[i-1][j]
	public void printPascalTriangle(int n) {
		
		// TC: O(n^2) SC: O(n^2)
		// Sample Output
		//n=5;
//		[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
//
//				Total Execution time: 200ms
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<n;i++) {
			ArrayList<Integer> ds = new ArrayList<Integer>();
			int start = 0,end = i;
			while(start <= end) {
				if(start == 0 || start == end) {
					ds.add(1);
				}else {
					ds.add(matrix.get(i-1).get(start-1)+ matrix.get(i-1).get(start));					
				}
				start++;
			}
			matrix.add(ds);
		}
		
		System.out.println(matrix);
	}
	
	
	// USE Boyer Moore's voting algorithm for optimal solution with TC:O(N), SC:O(1)
	public void elementsGreaterThanNby3(int[] arr) {
		int n= arr.length;
		int k= n/3;
		
		// TC: O(n) SC:O(n)
//		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
//		HashSet<Integer> hset = new HashSet<Integer>();
//		
//		for(int i=0;i<n;i++) {
//			if(hmap.get(arr[i]) == null) {
//				hmap.put(arr[i], 1);
//			}else {
//				int count = hmap.get(arr[i]);
//				hmap.put(arr[i], count+1);
//				if(count+1 > k) {
//					hset.add(arr[i]);
//				}
//			}
//		}
//		
//		System.out.println(hset);
		
		
		//Bayer Moore Algorithms
		int candidate = -1;
		int prev_candidate = -1;
		int count =0;
		
		for(int i=0;i<n;i++) {
			if(count == 0) {
				prev_candidate = candidate;
				candidate = arr[i];
				count = 1;
			}else {
				if(candidate == arr[i]) {
					count++;
				}else {
					count--;
					if(count == 0 && i == n-1) {
						prev_candidate = candidate;
						candidate = arr[i];
					}
				}
			}
		}
		
		count = 0;
		int prev_count = 0;
		for(int i=0;i<n;i++) {
			if(candidate == arr[i]) {
				count++;
			}
			if(prev_candidate == arr[i]) {
				prev_count++;
			}
		}
		
		System.out.println("Candidate: "+candidate+", prev_Candidate: "+prev_candidate);
		
		
		if(count > k) {
			System.out.println(candidate);
		}
		
		if(prev_count >k && candidate != prev_candidate) {
			System.out.println(prev_candidate);
		}
		
		if(count <k && prev_count <k){
			System.out.println(-1);
		}
		
	}
	
	public void tripletsSumZero(int[] arr,int i,int j, int k,ArrayList<ArrayList<Integer>> list) {
		if(arr[i]+arr[j]+arr[k] == 0) {
			ArrayList<Integer> ds = new ArrayList<Integer>();
			
		}
	}
	
	public void rankTeamsByVotes(String[] strArr) {
		String s = "";
		int n= strArr[0].length();
		
		HashMap<Integer,HashSet<Character>> hmap = new HashMap<Integer,HashSet<Character>>();
		
		for(int i=0;i<n;i++) {
			HashSet<Character> h = new HashSet<Character>();
			for(String str: strArr) {
				if(hmap.get(i) != null) {					
					h = hmap.get(i);
				}
				h.add(str.charAt(i));
				hmap.put(i, h);
			}
		}
		
		System.out.println(hmap);
		String str = "";
		
		for(int i=0;i<n;i++) {
			str += getFinalChar(i,hmap,n);
		}
		
		System.out.println(str);
		
	}
	
	public char getFinalChar(int index, HashMap<Integer,HashSet<Character>> hmap,int n) {
		if(hmap.get(index).size() == 1) {
			Object[] charArray = hmap.get(index).toArray();
			char ch = (char) charArray[0];
			return ch;
		}else {
			for(int j=0;j<n;j++) {
				if(index != j) {
					
				}
			}
		}
		
		return 0;
	}
	
	public void nextGreaterElement(int[] nums1,int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		
		for(int i=0;i<n2;i++) {
			hmap.put(nums2[i], i);
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<n1;i++) {
			int k = nextEle(nums1[i],hmap.get(nums1[i]),nums2);
			arr.add(k);
		}
		
		System.out.println(arr);
	}
	
	public int nextEle(int x,int index,int[] nums2) {
		for(int i=index+1;i<nums2.length;i++) {
			if(nums2[i] > x) {
				return nums2[i];
			}
		}
		return -1;
	}
	
	public void repeatingAndMissig(int[] arr) {
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(hmap.get(arr[i]) == null) {
				hmap.put(arr[i], 1);
			}else {
				hmap.put(arr[i], hmap.get(i+1)+1);
				hset.add(arr[i]);
			}
		}
		
		for(int i=1;i<=arr.length;i++) {
			if(hmap.get(i) == null) {
				hset.add(i);
			}
		}
		
		System.out.println(hmap);
		System.out.println(hset);
	}
	
	public void mergeTwoArraysWithoutExtraSpace(int[] arr1,int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		
		int j = 0;
		// Better Solution
		while(j < m) {
			
			int i=0;
			while(i<n) {
				if(arr1[i] > arr2[j]) {
					arr1[i] = arr1[i]+arr2[j];
					arr2[j] = arr1[i]-arr2[j];
					arr1[i] = arr1[i]-arr2[j];
				}
				i++;
			}
			j++;
		}
		
		
		for(int i=0;i<n;i++) {
			System.out.print(arr1[i]+" ");
		}
		
		System.out.println();
		Arrays.sort(arr2);
		
		for(int i=0;i<m;i++) {
			System.out.print(arr2[i]+" ");
		}
	}
	
	public void tripletsWithZeroSum(int[] arr) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int n = arr.length;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k= j+1;k<n;k++) {
					if(arr[i]+arr[j]+arr[k] == 0) {
						
						int l = list.size();
						int count = 0;
						while(l-- >0) {
							ArrayList<Integer> ds1 = new ArrayList<Integer>();
							ds1 = list.get(l);
							if(ds1.contains(arr[i]) && ds1.contains(arr[j]) && ds1.contains(arr[k])) {
								count = 1;
								break;
							}
						}
						
						if(count == 0) {
							ArrayList<Integer> ds = new ArrayList<Integer>();
							ds.add(arr[i]);
							ds.add(arr[j]);
							ds.add(arr[k]);
							list.add(ds);
						}
					}
				}
			}
		}
		
		System.out.println(list);
	}

	
	
	
}
