package binarySearch;

public class bsQuestions {
	public int Search(int[] arr,int k,int low,int high) {
		if(low > high) {
			return -1;
		}
		
		int mid = low + (high-low)/2;
		
		if(arr[mid] == k) {
			return k;
		}else if(arr[mid] > k) {
			high = mid-1;
			return Search(arr,k,low,high);
		}else {
			low = mid+1;
			return Search(arr,k,low,high);
		}
	}
	
	public int elementThatAppearsOnceInSortedArray(int[] arr,int low,int high) {
		
		
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if(mid ==0) {
				return arr[mid] != arr[mid+1] ? mid: -1;
			}else if(mid == arr.length-1) {
				return arr[mid] != arr[mid-1] ? mid: -1;
			}
			
			if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) {
				return mid;
			}else if(arr[mid] > arr[mid-1]) {
				return elementThatAppearsOnceInSortedArray(arr,low,mid-1);
			}else {
				return elementThatAppearsOnceInSortedArray(arr,mid+1,high);
			}
		}
		
		return -1;
	}
	
	public int kthElementInFinalSortedArray(int[] arr1,int[] arr2,int k) {
		int m = arr1.length;
		int n = arr2.length;
		if(m>n) {
			return kthElementInFinalSortedArray(arr2,arr1, k);
		}
		
		int low = k > m ? k-m: 0, high = k >n ? n:k;
		
		while(low <= high) {
			int cut1 = low + (high-low)/2;
			int cut2 = k-cut1;
			int l1 = cut1 == 0 ? Integer.MIN_VALUE: arr1[cut1-1];
			int r1 = cut1 == m ? Integer.MAX_VALUE : arr1[cut1];
			int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2-1];
			int r2 = cut2 == n ? Integer.MAX_VALUE : arr2[cut2];
			
			if(l1 <= r2 && l2 <= r1) {
				return Math.max(l1, l2);
			}else if(l1 > r2) {
				high = cut1 -1;
			}else if(l2 > r1) {
				low = cut1+1;
			}
			
		}
		
		return -1;
	}
}
