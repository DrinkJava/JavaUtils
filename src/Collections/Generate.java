package Collections;

public class Generate {
	public static int[] randIntArr(int i, int floor, int ceiling) {
		int[] arr = new int[i];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = (int) (ceiling * Math.random() + floor);
		}
		return arr;
	}
}
