package array;

public class ArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,2,0,3};
		int[] arr2 = {1,1,2,2,3,4,4};
		int[] arr3 = {1,0,1,1,0};
		int[] arr4 = {8,6,1,2,4,4};
		
		long start_time = System.nanoTime();
		
		ArrayEasy easy = new ArrayEasy();
		//System.out.println(easy.largestInArray(arr));
		//System.out.println(easy.secondLargestArray(arr));
		
		//System.out.println(easy.isSorted(arr));
		//easy.removeDuplicatesFromSorted(arr);
		//easy.leftRotate(arr, 5);
		//easy.moveAllZerosToEnd(arr);
		//easy.union(arr, arr2);
		//easy.intersection(arr, arr2);
		//easy.missingNumber(arr2);
		//easy.mostConsequentOnes(arr3);
		//easy.numberThatAppearOnce(arr2);
		System.out.println(easy.longestSubArrayWithGivenSum(arr4, 7));
		
		long end_time = System.nanoTime();
		
		long duration = (end_time - start_time)/10000;
		
		System.out.println("\nTotal Execution time: "+ duration+"ms");
	}

}
