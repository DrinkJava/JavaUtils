import static Collections.Sorts.*;
import static Collections.Generate.*;


public class Driver {
	public static void main(String[] args) {
		int[] arr = randIntArr(50, 10, 100);
		quickSort(arr);
		
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
