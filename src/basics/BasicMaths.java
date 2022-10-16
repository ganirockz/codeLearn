package basics;

public class BasicMaths {
	public int countDigits(int n) {
		int count =0;
		while(n>0) {
			n =n/10;
			count++;
		}
		return count;
	}
	
	public int numberReverse(int n) {
		int temp = n;
		int rev = 0;
		
		while(n>0) {
			rev = rev*10+ n%10;
			n = n/10;
		}
		
		return rev;
	}
	
	public boolean isPalindrom(int n) {
		
		int rev = this.numberReverse(n);
		if(n == rev) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public int gcd(int a,int b) {
		
		// naive solution
//		int c = Math.min(a, b);
//		
//		for(int i=c;i>0;i--) {
//			if(a%i == 0  && b%i==0) {
//				return i;
//			}
//		}
//		
//		return 1;
		
		// Euclidian approch
		if(b == 0) {
			return a;
		}
		
		return gcd(b,a%b);
	}
	
	public boolean armstrongNumber(int n) {
		int temp = 0;
		int duplicate = n;
		
		while(duplicate > 0) {
			int rem = duplicate%10;
			temp = temp+ (rem*rem*rem);    //50ms
			//temp += (int) Math.pow(rem, 3);  //68ms
			duplicate = duplicate/10;
		}
		
//		if(n == temp) {
//			return true;
//		}else {
//			return false;
//		}
		
		return n == temp;
	}
	
	
	public void divisors(int n) {
		System.out.println("Divisor of "+n+" are: ");
		
		// without prime check
//		for(int i=1;i<=n;i++) {
//			if(n%i ==0) {
//				System.out.print(i+" ");
//			}
//		}
		
		// with prime check
		if(this.isPrime(n)) {
			System.out.print(1+" "+n);
		}else {
			for(int i=1;i<=n;i++) {
				if(n%i ==0) {
					System.out.print(i+" ");
				}
			}
		}
		
		System.out.println();
	}
	
	public boolean isPrime(int n) {
		//int count =0;
		
		// naive approach
//		for(int i=2;i<n;i++) {
//			if(n%i == 0) {
//				count++;
//				break;
//			}
//		}
		
		// optimized approach - loop till square root
		
		for(int i=2;i*i< n;i++) {
			if(n%i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
