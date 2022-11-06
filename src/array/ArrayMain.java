package array;

public class ArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,2,0,3};
		int[] arr2 = {1,1,2,2,3,4,4};
		int[] arr3 = {1,0,1,1,0};
		int[] arr4 = {8,6,1,2,4,4};
		int[] arr5 = {2,0,2,1,1,0};
		int nums[] = {2,2,1,1,1,2,2};
		int ans[] = {-1,-2,-3,-4};
		int arr6[] = {-2,1,-3,4,-1,2,1,-5,4};
		
		long start_time = System.nanoTime();
		
		//ArrayEasy easy = new ArrayEasy();
		ArrayMedium medium = new ArrayMedium();
		
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
		//System.out.println(easy.longestSubArrayWithGivenSum(arr4, 7));
		//medium.elementsWithGivenSum(arr4,7);
		
		//medium.sortZerosOnesTwos(arr5);
		
		//System.out.println(medium.majorityElementThatRepeats(nums)); 
		//System.out.println(medium.canWeContinue(ans));
//		System.out.println(medium.isDSame(ans));
//		for(int i=0;i<ans.length;i++) {
//        	System.out.print(ans[i]+" ");
//        }
		
		//System.out.println(medium.kadaneProb(ans)); 
		//int[] stock = {7,1,5,3,6,4};
		
		//medium.maxSubArray(ans);
		
		//System.out.println(medium.stockBuyAndSell(stock));
		int[] array= {5,4,3,2,1};
		System.out.println(medium.countInversions(array));
		
		long end_time = System.nanoTime();
		
		long duration = (end_time - start_time)/10000;
		
		System.out.println("\nTotal Execution time: "+ duration+"ms");
	}
	

}
