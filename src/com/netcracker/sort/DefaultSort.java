package com.netcracker.sort;
import java.lang.reflect.Method;

import java.util.Arrays;

public class DefaultSort implements Printable, Sortable {

	private int[] array;

	public DefaultSort(){
		
	}
	
	@Override
	public void setArray(int[] array) {
		this.array = array;
	}
	
	public DefaultSort(ArrayGenerator array) {
		this.array = array.getArray();
		sort();
	}

	/**
	 * Using sort method from Arrays class
	 */
	@Override
	@MethodInvocation
	public void sort() {
		Arrays.sort(array);
	}

	@Override
	public int[] getArray() {
		return array;
	}

}
