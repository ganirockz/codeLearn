package sorting;

public class SortingMain {
	public static void main(String[] args) {
		int[] arr = {1,3,4,2,5};
		
		long start_time = System.nanoTime(); 
		
		SortingOne sort = new SortingOne();
		//sort.bubbleSort(arr);
		//sort.selectionSort(arr);
		sort.selectionSort(arr);
		
		long end_time = System.nanoTime();
		
		long duration = (end_time - start_time);
		
		duration /= 10000;
		
		System.out.println("\nTotal Execution time: "+ duration+"ms");
		
		
	}
}
