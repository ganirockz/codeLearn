package sorting;

public class SortingTwo {
	
	// TC: O(nlogn), SC: O(n)
	public void mergeSort(int[] arr, int low, int high) {
		if(low == high) {
			return;
		}
		int mid = low + (high-low)/2;
		
		mergeSort(arr, low,mid );
		mergeSort(arr,mid+1,high);
		
		while(low < high) {
			if(arr[low] > arr[high-1]) {
				int temp = arr[low];
				arr[low] = arr[high-1];
				arr[high-1] = temp;
			}
			low++;
			high--;
		}
	}
	
	//OUTPUT
//	10 40 30 80 90 50 70 
//	Total Execution time: 301ms
	

	// TC: O(nlogn) SC: O(1)
	public void quickSort(int[] arr,int start, int end) {
		if(start < end) {
			int pi = partition(arr,start,end);
			
			quickSort(arr, start, pi-1);
			quickSort(arr, pi+1, end);
		}		
	}
	
	// OUTPUT
//	10 30 40 50 70 80 90 
//	Total Execution time: 182ms
	
	public int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		
		int i=start-1;
		
		for(int j=start;j<=end-1;j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;
		
		return i+1;
		
	}
	
}
