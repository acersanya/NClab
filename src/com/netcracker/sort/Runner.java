package com.netcracker.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

	public static final int LENGTH = 1000;

	/**
	 * This method is iterating through all algorithms and
	 * in inner loop it iterating through different methods of array
	 * filling. First method  of ArrayGenerator is invoked after that
	 * sort method is been invoked according to ArrayGenerator filling method 
	 * @param arrayGenerator used for generating arrays
	 * @param sortAlgorithm implemented sorting algorithms
	 */
	private static void sortUsingReflection(ArrayGenerator arrayGenerator, Sortable[] sortAlgorithm) {
		arrayGenerator.generate(LENGTH);
		fillSortable(sortAlgorithm, arrayGenerator);

		for (Sortable i : sortAlgorithm) {
			Method[] methods = i.getClass().getMethods();
			for (Method method : methods) {
				MethodInvocation annos = method.getAnnotation(MethodInvocation.class);
				Method[] fillMethods = arrayGenerator.getClass().getMethods();
				for (Method j : fillMethods) {
					FillArray fill = j.getAnnotation(FillArray.class);
					if (fill != null) {
						if (annos != null) {
							try {
								j.invoke(arrayGenerator, LENGTH);
								method.invoke(i);
								ModelView.print((Printable) i);
								System.out.println();
							} catch (InvocationTargetException | IllegalAccessException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	/**
	 * This method is using Reflection API and Annotation to invoke annotated method
	 * @param sortAlgorithm all implemented algorithm
	 * @param arrayGenerator generates sequence of numbers and fill array
	 * @param arraySize 
	 */
	
	private static void timeCountingInvoking(Sortable[] sortAlgorithm, ArrayGenerator arrayGenerator, int[] arraySize) {
		long start;
		long finish;
		for (int i : arraySize) {
			arrayGenerator.generate(i);
			//creating sort objects and pass array class to constructor
			fillSortable(sortAlgorithm, arrayGenerator);
			//Sortable is interface for sorting algorithm
			for (Sortable j : sortAlgorithm) {
				Method[] methods = j.getClass().getMethods();
				for (Method method : methods) {
					MethodInvocation annos = method.getAnnotation(MethodInvocation.class);
					if (annos != null) {
						try {
							//measuring time here
							start = System.nanoTime();
							method.invoke(j);
							finish = System.nanoTime();
							ModelView.printTime(start, finish);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				}
			}

		}
	}

	/**
	 * Create Sortable objects and pass array to it's constructor
	 * @param sortAlgorithm (QuickSort,Bubble,Array.sort(),Merge)
	 * @param arrayGenerator class used for generating random arrays
	 */
	private static void fillSortable(Sortable[] sortAlgorithm, ArrayGenerator arrayGenerator) {
		sortAlgorithm[0] = new QuickSort(arrayGenerator);
		sortAlgorithm[1] = new MergeSort(arrayGenerator);
		sortAlgorithm[2] = new DefaultSort(arrayGenerator);
		sortAlgorithm[3] = new BubbleSort(arrayGenerator);
	}

	public static void main(String[] args) {

		Sortable[] sortAlgorithm = new Sortable[4];
		ArrayGenerator arrayGeneraot = new ArrayGenerator();
		int[] arraySize = { 100, 1000, 10000, 10000, 100000, 1000, 100000 };
		//reflectionSort(arrayGeneraot, sortAlgorithm);
		timeCountingInvoking(sortAlgorithm, arrayGeneraot, arraySize);

	}
}
