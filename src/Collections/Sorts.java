package Collections;

public final class Sorts {
	
	public static void mergeSplit(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		mergeSplit(arr, lo , mid);
		mergeSplit(arr, mid, hi);
		
		merge(arr, lo, hi);
	}
	
	public static void merge(int[] arr, int lo, int hi) {
		int left = 0;
		int[] temp = new int[arr.length];
		temp[left++] = arr[lo] < arr[hi] ? arr[lo] : arr[hi];
		
	}
	
	public static void quickSort(int arr[], int lo, int hi) {
		int index = partition(arr, lo, hi, pivot)
		while (pivot <= arr.length)
			pivot = partition(arr, 0, arr.length-1, pivot);

		
	}
	public static int partition(int[] arr, int lo, int hi) {
		int pivot = (hi+lo)/2;
		if (hi == lo) {
			if (arr[lo] < pivot)
				return lo;
			else
				return lo - 1;
		}
		else if (arr[lo] <= pivot)
			return partition(arr, lo+1, hi);
		else {
			swap(arr, lo, hi);
			return partition(arr, lo, hi-1);
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}
