package binarySearch;

public class BSMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bsQuestions BS = new bsQuestions();
		//int[] array = {1,1,2,2,3,3,4,4};
		
		//System.out.println(BS.elementThatAppearsOnceInSortedArray(array, 0, array.length-1));
		
		int[] array = {2,3,6,7,9};
		int[] array2 = {1,4,8,10};
		int k = 5;
		System.out.println(BS.kthElementInFinalSortedArray(array, array2, k));
	}

}
