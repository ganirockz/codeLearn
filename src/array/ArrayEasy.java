package array;
import java.util.*;

public class ArrayEasy {
	public int largestInArray(int[] arr) {
		if(arr.length == 0) {
			return -1;
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		return max == Integer.MIN_VALUE ? arr[0]: max;
	}
	
	public int secondLargestArray(int[] arr) {
		if(arr.length == 0 || arr.length == 1) {
			return -1;
		}
		
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > max) {
				secondMax = max;
				max = arr[i];
			}else if(arr[i] > secondMax && arr[i] != max) {
				secondMax = arr[i];
			}
		}
		
//		for(int i=0;i<arr.length;i++) {
//			if(arr[i]> secondMax && arr[i] < max) {
//				secondMax = arr[i];
//			}
//		}
		
		return secondMax;
	}
	
	public boolean isSorted(int[] arr) {
		int k = arr[0] - arr[1];
		for(int i=1;i<arr.length-1;i++) {
			int l = arr[i] - arr[i+1];
			if(k*l < 0) {
				return false;
			}
		}
		return true;
		
	}
	
	public void removeDuplicatesFromSorted(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i] != arr[i+1]) {
				list.add(arr[i]);
			}
		}
		//if(arr[arr.length -2] != arr[arr.length-1]) {
			list.add(arr[arr.length-1]);
		
		
		System.out.println(list);
	}
	
	public void leftRotate(int[] arr, int d) {
		int n= arr.length;
		d = d%n;
		if(d >0) {
			while(d-- >0) {				
				int temp = arr[0];
				for(int i=0;i<n-1;i++) {
					arr[i] = arr[i+1];
				}
				arr[n-1] = temp;
			}
		}
		
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public void moveAllZerosToEnd(int[] arr) {
		int n= arr.length;
		int countZero = 0;
		
		int i=0,j=0;
		while(i <n) {
			if(arr[i] == 0) {
				countZero++;
			}else {
				if(i != j) {					
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
			i++;	
		}
		
		while(j < n) {
			arr[j] = 0;
			j++;
		}
		
		print(arr);
	}
	
	public void union(int[] arr,int[] array) {
		int n = arr.length;
		int m = array.length;
		
		int k = n> m? m: n;
		TreeSet<Integer> tree = new TreeSet<Integer>();
		
		int i=0;
		for(;i<k;i++) {
			tree.add(arr[i]);
			tree.add(array[i]);
		}
		
		int l = m-n;
		if(l == 0) {
			//l = l*-1;
		}else if(l<0) {
			int j= i;
			l = l*-1;
			for(;j<i+l && j<n;j++) {
				tree.add(arr[j]);
			}
		}else {
			int j=i;
			for(;j<i+l && j<m;j++) {
				tree.add(arr[j]);
			}
		}
		
		System.out.println(tree);
	}
	
	public void intersection(int[] arr1,int[] arr2) {
		TreeSet<Integer> tree = new TreeSet<>();
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if((arr1[i] ^ arr2[j]) == 0) {
					tree.add(arr1[i]);
				}
			}
		}
		
		System.out.println(tree);
	}
	
	public void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public void missingNumber(int[] arr) {
		int n = arr.length;
		int[] visited = new int[n+1];
		for(int i=0;i<n;i++) {
			visited[arr[i]]++;
		}
		int miss = -1;
		for(int i=1;i<=n;i++) {
			if(visited[i] == 0) {
				miss = i;
				break;
			}
		}
		
		System.out.println("Missing Number: "+ miss);
	}
}
