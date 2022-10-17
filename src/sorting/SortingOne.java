package sorting;

public class SortingOne {
	
	// TC: O(n^2) SC: O(1)
	public void selectionSort(int[] arr) {
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			int minIndex = i;
			
			for(int j=i+1;j<n-1;j++) {
				if(arr[j]< arr[i]) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
		
		//this.print(arr);
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
		//OUTPUT
//		1 2 3 4 5 
//		Total Execution time: 106ms
		
	}
	
	public void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	// TC: O(n^2) SC: O(1)
	public void bubbleSort(int[] arr) {
		
		int l = arr.length;
		
		for(int i=0;i<l;i++) {
			for(int j=i+1;j<l;j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		//print Array
		
		for(int i=0;i<l;i++) {
			System.out.print(arr[i]+" ");
		}
		
		//OUTPUT
//		1 2 3 4 5 
//		Total Execution time: 118ms
	}
	
	
	// TC: O(n^2) SC: O(1)
	public void insertionSort(int[] arr) {
		int n= arr.length;
		
		for(int i=1;i<n;i++) {
			int current = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]> current) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j] = current;
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		

		//OUTPUT
//		1 2 3 4 5 
//		Total Execution time: 104ms
	}
}
