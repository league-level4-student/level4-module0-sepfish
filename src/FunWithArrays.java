public class FunWithArrays {
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int[] b = {4, 5, 6};
		
		printArray(a);
		printArray(b);
		
		a = b;
		
		printArray(a);
		printArray(b);
		
		a[1] = 9;
		
		printArray(a);
		printArray(b);
	}
	
	static void printArray(int[] arr) {
		for (int a: arr) {
			System.out.print(a);
		}
		System.out.print("\n");
	}
}
