package com.netcracker.sort;


public class BubbleSort implements Printable, Sortable {

	private int [] array;
	
	/**
	 * Getter
	 * @return array
	 */
	public int[] getArray() {
		return array;
	}
	
	/**
	 * Setter
	 * @param array
	 */
	public void setArray(int[] array) {
		this.array = array;
	}
	
	public BubbleSort(){
		
	}

	
	public BubbleSort(ArrayGenerator array) {
		this.array = array.getArray();
	}

	/**
	 * Sorting array using bubble root 
	 * Max element is stored at the and of array
	 */
	@Override
	@MethodInvocation
	public void sort() {
		for(int i = 0; i < array.length - 1; i++){
			for(int j = 0; j < array.length - i- 1; j++){
				if(array[j] > array[j+1]){
					swap(j, j+1);
				}
			}
		}
		
	}

	/**
	 * Swap i and j
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * Sort is the same as bubble sort
	 * But max element is stored at the beginning of the array
	 */
	public void reverseSort(){
		for(int i = 0; i < array.length -1; i++){
			for(int j = 0; j < array.length - 1 - i; j++){
				if(array[j] < array[j+1]){
					swap(j, j+1);
				}
			}
		}
	}
	
}
