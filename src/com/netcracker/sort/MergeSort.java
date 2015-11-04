package com.netcracker.sort;

public class MergeSort implements Printable, Sortable {

	private int[] array;
	private int[] temp;

	public MergeSort(ArrayGenerator obj) {
		this.array = obj.getArray();
		this.temp = new int[array.length];
		sort();
	}
	
	public MergeSort(){
		
	}
	
	
	public void setArray(int[] array) {
		this.array = array;
	}

	@MethodInvocation
	@Override
	public void sort() {
		mergeSort(0, array.length - 1);
	}

	/**
	 * Check if low is smaller then high, if yes
	 * array is sorted 
	 * @param low array element
	 * @param high  array element 
	 */
	public void mergeSort(int low, int high) {
		if (low < high) {
			//middle array index
			int middle = low + (high - low) / 2;
			//sort left array side
			mergeSort(low, middle);
			//sort right array side
			mergeSort(middle + 1, high);
			//Combine both parts
			merge(low, middle, high);
		}
	}

	/**
	 * Copying smallest element from right or left part of the array 
	 * @param low
	 * @param middle
	 * @param high
	 */
	public void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			temp[i] = array[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		while (i <= middle && j <= high) {
			if (temp[i] < temp[j]) {
				array[k] = temp[i];
				i++;
			} else {
				array[k] = temp[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			array[k] = temp[i];
			k++;
			i++;
		}
	}

	/**
	 * Getter
	 * @return sorted array
	 */
	@Override
	public int[] getArray() {
		return array;
	}

}
