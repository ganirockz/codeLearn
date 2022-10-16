package recursion;

public class RecursionBasics {
	public void printNTimes(int n) {
		if(n == 0) {
			System.out.println();
			return;
		}
		System.out.print("*"+" ");
		printNTimes(n-1);
	}
	
	public void oneToN(int n) {
		if(n==0) {
			//System.out.println();
			return;
		}
		oneToN(n-1);
		System.out.print(n+" ");
	}
	
	public void nToOne(int n) {
		if(n==0) {
			return;
		}
		System.out.print(n+" ");
		nToOne(n-1);
	}
	
	public int sumOfNumberOneToN(int n) {
		if(n ==0) {
			return 0;
		}
		
		return n+sumOfNumberOneToN(n-1);
	}
	
	public long factorial(int n) {
		if(n ==1 ) {
			return 1;
		}
		
		return n*factorial(n-1);
	}
	
	public int[] arrayReverse(int[] arr,int n,int[] array) {
		if(n ==0) {
			return array;
		}
		array[n-1] = arr[arr.length-n];		
		return arrayReverse(arr, n-1,array);
	}
	
	public int[] arrayReverseUsingSingleArray(int[] arr, int start, int end) {
		if(start > end) {
			return arr;
		}
		
		// swapping
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
		
		//Note: Dont use post increment operator in parameter
		return arrayReverseUsingSingleArray(arr, start+1, end-1);
	}
	
	public boolean isPalindrome(String s,int start,int end) {
		if(start > end) {
			return true;
		}
		if(s.charAt(start) != s.charAt(end)) {
			return false;
		}
		
		return isPalindrome(s, start+1, end-1);	
	}
	
	public void fibonacciSeries(int[] arr, int n) {
		if(n == 1) {
			return;
		}
		
		fibonacciSeries(arr, n-1);
		arr[n]= arr[n-1]+arr[n-2]; 
		System.out.print(arr[n]+" ");
	}
	
	public void fibonacciWithoutArray(int secondLast,int last,int counter) {
		if(counter == 2) {
			return;
		}
		System.out.print(secondLast+last+" ");
		
		fibonacciWithoutArray(last, secondLast+last, counter-1);
		
	}
	
	
}
