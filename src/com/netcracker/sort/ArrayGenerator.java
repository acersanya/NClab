package com.netcracker.sort;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;




public class ArrayGenerator implements Printable, Cloneable {

	//make arrayGenerator as Singleton
	
	public ArrayGenerator() {
		// TODO Auto-generated constructor stub
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
	 * Fill array from 1 to len -1 , last element
	 * set randomly
	 * @param length
	 */
	@FillArray
	public void fillArrayOne(int length){
		Random rand  = new Random();
		array = IntStream.rangeClosed(0, length).toArray();
		this.array[length - 1] = rand.nextInt(100);
	}
	
	/**
	 * Fill array and reverse it
	 * @param length
	 */
	@FillArray
	public void fillArrayTwo(int length){
		array = IntStream.rangeClosed(0, length).toArray();
		ArrayUtils.reverse(array);
	}
	
	@FillArray
	public void fillArrayThree(int length){
		array = IntStream.rangeClosed(0, length).toArray();
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
