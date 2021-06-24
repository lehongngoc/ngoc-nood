package bai1;

public class bai1 {

	public static void main(String[] args) {
		   fibonacci(40);

	}// Hàm in ra dãy số fibonacci
	 public static void fibonacci(int maxNumber) {
	        int previousNumber = 0;
	        int nextNumber = 1;
	        System.out.print("Dãy số fibonacci là:" + maxNumber + " numbers:");
	        for (int i = 1; i <= maxNumber; ++i) {
	            System.out.println(previousNumber + " ");
	            int sum = previousNumber + nextNumber;
	            previousNumber = nextNumber;
	            nextNumber = sum;
	        }
	    }
}
