package chapter17_hard;

public class MissingTwo {

	public static void main(String[] args) {
		int n = 10;
		int[] arr = {1,3,2,6,5,8,10,4};
		int[] missingNums = getMissingTwo(arr,n);
		System.out.println(missingNums[0] + " " + missingNums[1]);

	}

	private static int[] getMissingTwo(int[] arr,int n) {
		int[] res = new int[2];
		
		//expected
		int sumOfTwo = (n*(n+1))/2;
		int sumOfSquareofTwo = sumOfTwo * ((2*n + 1)/3);
		
		//subtracting to get missing two sum and square values
		for(int i = 0; i < arr.length; i++) {
			sumOfTwo -= arr[i];
			sumOfSquareofTwo -= (arr[i] * arr[i]);
		}
		
		//(a+b)^2 = a^2 + b^2 + 2ab
		//ab = ((a+b)^2 - (a^2 + b^2))/2
		
		int prodOfTwo = ((sumOfTwo*sumOfTwo) - sumOfSquareofTwo)/2;
		
		//ax^2 + bx + c = 0
		//x^2 - (sumOfTwo)x + prodOfTwo = 0
		//(-b(+-)(b^2-4ac)^1/2)/2a
		//(sumOfTwo(+-)(sumOfTwo^2 - 4prodOfTwo))/2
		
		int d = (int) Math.sqrt((sumOfTwo*sumOfTwo) - (4*prodOfTwo));
		
		res[0] = (sumOfTwo + d )/2;
		res[1] = (sumOfTwo - d )/2;
		
		return res;
	}

}
