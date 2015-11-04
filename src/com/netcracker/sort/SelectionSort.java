package com.netcracker.sort;

public class SelectionSort implements Printable, Sortable {

	private int[] array;

	public SelectionSort(){
		
	}
	
	public SelectionSort(ArrayGenerator array) {
		this.array = array.getArray();
		sort();
	}
	
	
	public void setArray(int[] array) {
		this.array = array;
	}
	

	/**
	 * Sorting algorithm using Selection sort
	 */
	@Override
	@MethodInvocation
	public void sort() {
		for (int i = 0; i < array.length - 1; i++) {
			int min = array[i];
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					minIndex = j;
				}

			}
			swap(i, min, minIndex);
		}

	}

	/**
	 * Swap min element in array with current 
	 * element at the beginning of the array 
	 * @param i
	 * @param min
	 * @param minIndex
	 */
	private void swap(int i, int min, int minIndex) {
		int temp = array[i];
		array[i] = min;
		array[minIndex] = temp;
	}
	/*
	 * (non-Javadoc)
	 * @see com.netcracker.sort.Printable#getArray()
	 */
	@Override
	public int[] getArray() {
		return array;
	}

}
