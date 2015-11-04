package com.netcracker.sort;

public class QuickSort implements Printable, Sortable {

	private int[] array;

	public QuickSort(){
		
	}
	
	
	public QuickSort(ArrayGenerator array) {
		this.array = array.getArray();
		sort();
	}

	/**
	 * Array setter
	 */
	public void setArray(int[] array) {
		this.array = array;
	}
	
	/**
	 * calling quick sort method here
	 */
	


	
	@Override
	@MethodInvocation
	public void sort() {
		quickSort(0, array.length - 1);
	}
	
	/**
	 * Quick sort algorithm
	 * @param low
	 * @param high
	 */

	public void quickSort(int low, int high) {
		int i = low;
		int j = high;
		int median = array[low + (high - low) / 2];

		while (i <= j) {
			while (array[i] < median) {
				i++;
			}
			while (array[j] > median) {
				j--;
			}

			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}

		if (low < j) {
			quickSort(low, j);
		}
		if (i < high) {
			quickSort(i, high);
		}

	}
	/**
	 * Swap two elements using third
	 * @param i first element
	 * @param j second element
	 */

	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * Array getter
	 */
	@Override
	public int[] getArray() {
		return array;
	}

}
