package contests;

public class mainToExceute {
	public static void main(String[] args) {
		GeeksWeeklyContest gwc = new GeeksWeeklyContest();
		//int[] arr = {1,2,3};
		
		
		long start_time = System.nanoTime();
		int[] arr = {1,1,1,0,0,0,0,0,0,0};
		int n=4;
		int[] b = new int[n];
		
		System.out.println(gwc.canWeBowlNThrowsAsPerRules(arr, n, b));
		
		for(int i=0;i<n;i++) {
			System.out.print(b[i]+" ");
		}
		
		long end_time = System.nanoTime();
		
		long duration = (end_time-start_time)/10000;
		System.out.println(duration+" ms");
	}
}
