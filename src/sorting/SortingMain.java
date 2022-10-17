package sorting;

public class SortingMain {
	public static void main(String[] args) {
		int[] arr = {10, 80, 30, 90, 40, 50, 70};
		
		long start_time = System.nanoTime(); 
		
		SortingOne sort1 = new SortingOne();
		//sort.bubbleSort(arr);
		//sort.selectionSort(arr);
		//sort.selectionSort(arr);
		
		SortingTwo sort = new SortingTwo();
//		sort.mergeSort(arr, 0, 5);
//		sort1.print(arr);
		//System.out.println(sort.partition(arr, 0, arr.length-1));
		
		sort.quickSort(arr, 0, arr.length-1);
		sort1.print(arr);
		
		long end_time = System.nanoTime();
		
		long duration = (end_time - start_time);
		
		duration /= 10000;
		
		System.out.println("\nTotal Execution time: "+ duration+"ms");
		
		
	}
}
