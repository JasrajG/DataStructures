package sortingAlgorithms;

public class Sort {

	
	public static void main(String args[]) {
		int[] array = {6, 4, 3, 5, 3, 4};
		//selectionSort(array);
		insertionSort(array);
		
	}
	
	
	
	

//Implementation from scratch of selection sort in non-acsending order given an input array
public static void selectionSort(int[] arr) {
	for (int i = arr.length-1; i >=1; i--) {
		int min_index = i;
		int min = arr[i];
		for (int j = i - 1; j>=0; j--) {
	
			if(min > arr[j]) {
				min_index = j;
				min  = arr[j];
			}
		}
		
		arr[min_index]=arr[i];
		arr[i]=min;
		
		
	}
	
}


//Implementation of insertion sort from scratch in non-ascending order



public static void insertionSort(int[] arr) {
	
	for (int i = arr.length - 1; i>=1; i--) {
		int j = i-1;
		
		while(j <= arr.length - 2 && arr[j] < arr[j+1]) {
			int temp = arr [j+1];
			arr[j+1] = arr[j];
			arr[j] = temp;
			j++;
		}
		
	}
	
}





}