package array;

import java.util.*;


public class ArrayMedium {
	public void elementsWithGivenSum(int[] arr,int k) {
		
		// Naive Solution
		
//		int i =0;
//		int j=0;
//		int n = arr.length;
//		int sum = k;
//		for(; i< n;i++) {
//			j=0;
//			sum -= arr[i];
//			for(;j<n;j++) {
//				if(i != j) {
//					if(sum - arr[j] == 0) {
//						break;
//					}
//				}
//			}
//			if(j< n && sum - arr[j] == 0) {
//				break;
//			}else {
//				sum =k;
//			}
//		}
//		
//		if(i<n && j<n) {
//			System.out.println(i+" "+j);
//		}else {
//			System.out.println("Not found");
//		}
		
		// Optimal Solution
		int n= arr.length;
		int flag =0;
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();

		for(int i=0;i<n;i++) {
			if(hmap.get(k - arr[i]) != null) {
				System.out.println(i+" "+hmap.get(k-arr[i]));
				flag++;
				break;
			}
			hmap.put(arr[i], i);
		}
		if(flag == 0)
			System.out.println("Not found");
		
	}
	
	// arr[] = {2,0,2,1,1,0}
	public void sortZerosOnesTwos(int[] arr) {
		
		
		// TC: O(n)+ O(n) SC: O(1)
		//OUTPUT:
//		0 0 1 1 2 2 
//		Total Execution time: 128ms
		
//		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
//		
//		
//		for(int i=0;i<arr.length;i++) {
//			if(hmap.get(arr[i]) == null) {
//				hmap.put(arr[i], 1);
//			}else {
//				int value = hmap.get(arr[i]);
//				hmap.put(arr[i], value+1);
//			}
//		}
//		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		
//		int zeroCount = hmap.get(0);
//		int oneCount = hmap.get(1);
//		int twoCount = hmap.get(2);
//		
//		for(int i=0;i<zeroCount;i++) {
//			list.add(0);
//		}
//		
//		for(int i=0;i<oneCount;i++) {
//			list.add(1);
//		}
//		
//		for(int i=0;i<twoCount;i++) {
//			list.add(2);
//		}
//		
//		System.out.println(list);
		
		//Dutch National Flag problem
		// TC: O(n) SC: O(1)
		//OUTPUT:
//		0 0 1 1 2 2 
//		Total Execution time: 116ms
		
		int low = 0,mid=0, high = arr.length-1;
		
		while(mid <= high) {
			
			switch(arr[mid]) {
				case 0: {
					int temp = arr[mid];
					arr[mid] = arr[low];
					arr[low] = temp;
					low++;
					mid++;
					break;
				}
				case 1: {
					mid++;
					break;
				}
				case 2: {
					int temp = arr[mid];
					arr[mid] = arr[high];
					arr[high] = temp;
					mid++;
					high--;
					break;
				}
			}
			
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	// return majority element that repeats n/2 times
	public int majorityElementThatRepeats(int[] arr){
		
		// TC: O(n) Sc: O(1)
		// OUTPUT:
//		2
//
//		Total Execution time: 119ms
//		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
//		int n= arr.length;
//		
//		for(int i=0;i<arr.length;i++) {
//			if(hmap.get(arr[i]) == null) {
//				hmap.put(arr[i], 1);
//			}else {
//				int value = hmap.get(arr[i]);
//				if(value+1 > n/2) {
//					return arr[i];
//				}else {
//					hmap.put(arr[i], value+1);
//				}
//			}
//		}
//		
//		return -1;
		
		
		// Moore’s Voting Algorithm
		// watch this video: https://youtu.be/n5QY3x_GNDg
		//OUTPUT:
		
//		2
//
//		Total Execution time: 99ms
		int n= arr.length;
		
		int candidate = 0, element = 0;
		int count = 0;
		
		for(int i: arr) {
			if(count == 0)
				candidate = i;
			else if(i == candidate) {
				count+=1;
			}else {
				count -=1;
			}
		}
		
		return candidate;
		
	}
	
	
	public static boolean canWeContinue(int[] arr){
		int n = arr.length;
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();

        for(int i=0;i<n;i++){
            if(hmap.get(arr[i]) == null){
                hmap.put(arr[i],1);
            }else{
                int value = hmap.get(arr[i]);
                if(value > 2){
                    return false;
                }else{
                    hmap.put(arr[i],value+1);
                }
            }
        }

        int count = 0;

        for(int k: hmap.keySet()){
            if(hmap.get(k) > 1){
                count++;
            }
        }

        if(count > 1){
            return false;
        }

        return true;
    }
	
	public static boolean isDSame(int[] arr){
        int n = arr.length;
        int prev_d = arr[1]-arr[0];
        for(int i=1;i<n-1;i++){
            int d = arr[i+1] - arr[i];
            if(prev_d != d){
            	arr[i+1] = arr[i]+d;
                return false;
            }
            prev_d = d;
        }
        
        
        return true;
    }
	
	public int kadaneProb(int[] arr) {
		
		
		//Naive Approach TC: O(n^3), SC: O(1)
//		-1
//
//		Total Execution time: 98ms
		
		int n = arr.length;
		
		int sum = Integer.MIN_VALUE;
		
		//Naive approach
//		for(int i=1;i<=n;i++) {
//			for(int j=0;j+i<=n;j++) {
//				int currentSum = 0;
//				for(int k=j;k<j+i;k++) {
//					currentSum += arr[k];
//				}
//				if(currentSum> sum) {
//					sum = currentSum;
//				}
//			}
//		}
		
		
		//Better Approach TC: O(n^2) SC: O(1)
//		-1
//
//		Total Execution time: 95ms
//		for(int i=0;i<n;i++) {
//			int currentSum = 0;
//			for(int j=i;j<n;j++) {
//				currentSum += arr[j];
//				if(currentSum>sum) {
//					sum = currentSum;
//				}
//			}
//		}
		
		
		//Best Approach TC:O(n) SC:O(1)
		//Kadane's algorithm - Most important
		int meh = 0;
		for(int i=0;i<n;i++) {
			meh += arr[i];
			if(meh>sum) {
				sum = meh;
			}
			
			if(meh<0) {
				meh = 0;
			}
		}
		
		return sum;
	}
	
	public void maxSubArray(int[] arr) {
		int n = arr.length;
		int sum = Integer.MIN_VALUE;
		int meh = 0;
		int start = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			meh += arr[i];
			if(meh>sum) {
				sum = meh;
				list.clear();
				list.add(start);
				list.add(i);
			}
			
			
			if(meh <0) {
				meh = 0;
				start = i+1;
			}
		}
		
		
		for(int i=list.get(0);i<=list.get(1);i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\nMax Sum: "+sum);
	}
	
	public int stockBuyAndSell(int[] arr) {
		int n= arr.length;
		//int profit = Integer.MIN_VALUE;
		
		//Naive Approach TC:O(n^2) SC:O(1)
//		for(int i=0;i<n;i++) {
//			for(int j=i+1;j<n;j++) {
//				if((arr[j]-arr[i]) > profit ) {
//					profit = arr[j]-arr[i];
//				}
//			}
//		}
		
		
		//Optimal Solution TC:O(n) SC: O(1)
		//Most important for logic building
		int profit = 0;
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			if(arr[i]-min>profit) {
				profit = arr[i]-min;
			}
		}
		
		
		
		return profit>0? profit: 0;
		
	}
	
	public int countInversions(int[] arr) {
		int count = 0;
		int n= arr.length;
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]>arr[j]) {
					count++;
				}
			}
		}
		
		return count;
	}
}
