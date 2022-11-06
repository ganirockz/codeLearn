package contests;
import java.util.*;

public class GeeksWeeklyContest {
	
	//Date: Nov 6 2022
	// total cuts with max of left cut+ min of right cut > k 
	public int totalCuts(int[] arr,int n,int k) {
		// Brute force TC:O(n^2)
//		int mlsf = arr[0];
//		
//		return nthCut(arr,n,k,1,mlsf);
		
		
		// Optimal Solution using precomputation TC:O(n)
		int count = 0;
		int[] maxi = new int[n];
		int[] mini = new int[n];
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
			
			maxi[i] = max;
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=n-1;i>=0;i--) {
			if(arr[i] < min) {
				min = arr[i];
			}
			mini[i] = min;
		}
		
		for(int i=0;i<n;i++) {
			if(maxi[i]+mini[i] > k) {
				count++;
			}
		}
		
		return count;
	}
	
	public int nthCut(int[] arr,int n, int k, int cut,int mlsf) {
		if(cut >= n) {
			return 0;
		}
		
		//int maxLeft = arr[0];
		int minRight = arr[n-1];
		
		
		
		for(int i=cut;i<n;i++) {
			if(arr[i] < minRight) {
				minRight = arr[i];
			}
		}
		
		if(arr[cut] > mlsf) {
			mlsf = arr[cut];
		}
		
		if(mlsf+minRight >= k) {
			return 1+ nthCut(arr,n,k,cut+1,mlsf);
		}else {
			return nthCut(arr,n,k,cut+1,mlsf);
		}
	}
	
	// 2. nth term in the series that contains only odd integers as digits. Eg: 1,3,5,7,9,11,13,15,17,19,31,33,35 etc
	// 3rd term is 5, 13th term is 35
	public int nthTermInSeries(int n) {
		
		//Naive Solution
		// For better solution use tree and do level order traversal using queue. 
		// initially five root nodes: 1,3,5,7,9
		// second level is combination of these number taken two at a time, like: 11,13,15,17,19 for node 1
		// similarly for node 3 there will be 31,33,35,37,39
		int count = 1;
		int i=1;
		while(count < n) {
			if(isIpartOfSeries(i)) {
				count++;
			}
			i+=2;
		}
		
		return i;
	}
	
	public boolean isIpartOfSeries(int k) {
		
		int temp = k;
		
		while(temp>0) {
			int digit = temp%10;
			if(digit%2 == 0) {
				return false;
			}
			temp = temp/10;
		}
		
		return true;
	}
	
	
	//https://practice.geeksforgeeks.org/contest/weekly-interview-series-75/problems#
	// Given an array size 10 which represents the speeds of bowl and this array contains 1s,0s.
	// if at 1st position there is 1 then it denotes the the 1kmph speed is allowed.
	// similarly if 2nd position has 0 then it denotes that 2kmph speed is not allowed.
	// we have throw a bowl one after other but the second one should through that one of the allowed speeds
	// this speed is such that the sum of all previous throws of that person should be greater than some of all previous throws of other person
	// But no two consecutive throw speed should be same
	// Note: n is not array length here, it's number of total throws
	public boolean canWeBowlNThrowsAsPerRules(int[] A,int n,int[] ballThrows) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<A.length;i++) {
			if(A[i] == 1) {
				arr.add(i+1);
			}
		}
		
		//int[] ballThrows = new int[n];
		
		return isThrowable(arr,n,0,0,0,0,0,ballThrows);
	}
	
	public boolean isThrowable(ArrayList<Integer> arr,int n, int index, int bssf, int mssf,int player,int prev,int[] ballThrows) {
		if(index >= n) {
			return true;
		}
		
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i) != prev) {
				if(player == 0) {
					System.out.println(bssf+" ok");
					if(bssf+arr.get(i)  > mssf) {
						ballThrows[index] = arr.get(i);
						bssf = bssf+arr.get(i);
						player = 1;
						prev = arr.get(i);
						return isThrowable(arr, n, index+1, bssf, mssf, player, prev, ballThrows);
					}
				}else {
					System.out.println(mssf+" not ok");
					if(mssf+arr.get(i) > bssf) {
						ballThrows[index] = arr.get(i);
						mssf = mssf+arr.get(i);
						player = 0;
						prev = arr.get(i);
						return isThrowable(arr, n, index+1, bssf, mssf, player, prev, ballThrows);
					}
				}
			}
		}
		
		
		
		
		
		return false;
	}
}
