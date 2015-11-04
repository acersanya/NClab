package com.netcracker.algospeed;


import java.util.Random;
import java.util.stream.IntStream;

import javax.jws.WebParam.Mode;

import com.netcracker.sort.ModelView;
import com.netcracker.sort.Sortable;
import org.apache.commons.lang3.ArrayUtils;

public class AlgorithmSpeed {

	private static final int LENGTH = 1000;
	private Sortable sortable;
	private int[] array = new int[LENGTH];
	private long start;
	private long finish;
	private static final  String meesageOne = "Algo speed using already sorted array";
	private static final  String messageTwo = "Algo speed using already sorted array except"
			+ "last element";
	private static final  String messageThree = "Algo speed using reverse sorte array";
	
	
	
	
	public AlgorithmSpeed(Sortable obj) {
		this.sortable = obj;
	}

	/**
	 * Speed test of already sorted array
	 */
	public void testAlreadySortedArray() {
		fillArray();
		sortable.setArray(array);
		countTime();
		ModelView.printMessage(meesageOne);
		ModelView.printTime(start, finish);
	}

	/**
	 * counting time using System.nano
	 * printTime represents algorithm work time 
	 * in seconds
	 */
	private void countTime() {
		start = System.nanoTime();
		sortable.sort();
		finish = System.nanoTime();
		ModelView.printMessage(messageTwo);
		ModelView.printTime(start, finish);
	}
	
	/**
	 * Test speed with sorted elements except
	 * the last, it's been taken randomly
	 */
	public void testAlreadySortedRandomEnd(){
		Random rand  = new Random();
		fillArray();
		// make last array element random
		this.array[LENGTH - 1] = rand.nextInt(100);
		sortable.setArray(array);
		countTime();
	}
	
	
	/**
	 * Test speed with reversed sorted array
	 */
	public void testSortReverse(){
		fillArray();
		//using org.apache.commonlang to reverse array
		ArrayUtils.reverse(array);
		sortable.setArray(array);
		ModelView.printMessage(messageThree);
		countTime();
		
	}

	/**
	 * fill array from 0 to LENGTH
	 */
	public void fillArray() {
		array = IntStream.rangeClosed(0, LENGTH).toArray();
	}

}
