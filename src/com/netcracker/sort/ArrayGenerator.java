package com.netcracker.sort;

import java.util.Random;

public class ArrayGenerator implements Printable, Cloneable {

	//make arrayGenerator as Singleton
	private static ArrayGenerator generator = new ArrayGenerator();
	private ArrayGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayGenerator getArrayGeneratorInst(){
		return generator;
	}
	
	private int[] array;
	
	/**
	 * Getter for array
	 * @return array
	 */
	public int[] getArray() {
		return array.clone();
	}

	/**
	 * Setter for array
	 * @param array 
	 */
	public void setArray(int[] array) {
		this.array = array;
	}

	/**
	 * Generate array with random numbers in interval from 0 to 100  not inclusive
	 * @param length of array 
	 */
	public void generate(int length) {
		Random rand = new Random();
		this.array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = rand.nextInt(100);
		}
	}

	/**
	 * Array printer
	 */
	public void printArray() {
		for (int i : this.array) {
			System.out.print(i + " ");
		}

	}
	
	/**
	 * Return clone for not changing inside data
	 */
	@Override
	public Object clone()  {
		ArrayGenerator temp = null;
		try {
			temp = (ArrayGenerator)super.clone();
			return temp;
		} catch (CloneNotSupportedException e){
			e.printStackTrace();
		}
		return temp;
	}
	

}
