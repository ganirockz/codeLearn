package recursion;

public class RecursionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecursionBasics r = new RecursionBasics();
		
		long start_time = System.nanoTime();
		
		//r.printNTimes(5);
		//r.oneToN(5);
		//r.nToOne(5);
		//System.out.println(r.sumOfNumberOneToN(5));
		//System.out.println(r.factorial(25));
		
		//int[] arr = new int[5];
//		int[] arr = {1,2,3,4,5};
//		int[] array = new int[5];
//		
		//arr = r.arrayReverse(arr, 5,array);
		
//		arr = r.arrayReverseUsingSingleArray(arr, 0, arr.length-1);
//		
//		for(int i=0;i<5;i++) {
//			System.out.print(arr[i]+" ");
//		}
		
		
//		String s = "heeh";
//		
//		System.out.println(r.isPalindrome(s, 0, s.length()-1));
		
//		int[] arr = new int[6];
//		arr[0] = 1;
//		arr[1] = 1;
//		
//		System.out.print(arr[0]+" "+arr[1]+" ");
//		
//		r.fibonacciSeries(arr, 5);
		
		
		System.out.print(0+" "+1+" ");
		r.fibonacciWithoutArray(0, 1,8);
		
		
		long end_time = System.nanoTime();
		
		long duration = end_time - start_time;
		duration /= 10000;
		System.out.println("\nExecutionTime: "+ duration+"ms");
	}

}
