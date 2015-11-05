package com.netcracker.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {
	
	public static final int LENGTh = 1000;
	
	
	private static void reflectionSort(ArrayGenerator array, Sortable[] sortAlgo) {
		for (Sortable i : sortAlgo) {
			Method[] methods = i.getClass().getMethods();
			for (Method method : methods) {
				MethodInvocation annos = method.getAnnotation(MethodInvocation.class);
				Method[] fillMethods = array.getClass().getMethods();
				for (Method j : fillMethods) {
					FillArray fill = j.getAnnotation(FillArray.class);
					if (fill != null) {
						if (annos != null) {
							try {
								j.invoke(array,LENGTh);
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
	
	public static void main(String[] args) {

		// AlgorithmSpeed buble = new AlgorithmSpeed(new BubbleSort());
		// buble.testAlreadySortedArray();
		// buble.testAlreadySortedRandomEnd();
		// buble.testSortReverse();

		// AlgorithmSpeed quick = new AlgorithmSpeed(new QuickSort());
		// quick.testAlreadySortedArray();
		//
		//
		// AlgorithmSpeed merge = new AlgorithmSpeed(new MergeSort());
		// quick.testAlreadySortedArray();
		//
		//
		// AlgorithmSpeed defArraySort = new AlgorithmSpeed(new DefaultSort());
		// quick.testAlreadySortedArray();

		ArrayGenerator array = new ArrayGenerator();
		array.generate(100);

		Sortable[] sortAlgo = new Sortable[4];
		sortAlgo[0] = new QuickSort(array);
		sortAlgo[1] = new MergeSort(array);
		sortAlgo[2] = new DefaultSort(array);
		sortAlgo[3] = new BubbleSort(array);

		reflectionSort(array, sortAlgo);

	}


}
