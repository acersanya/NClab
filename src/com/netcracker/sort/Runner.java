package com.netcracker.sort;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import com.netcracker.algospeed.AlgorithmSpeed;

public class Runner {

	public static void main(String[] args) {

		// ArrayGenerator array = new ArrayGenerator();
		// array.generate(5);
		// ModelView.print(array);
		// System.out.println();
		//
		// BubbleSort buble = new BubbleSort(array);
		// buble.sort();
		// ModelView.print(buble);
		//
		//
		// System.out.println();
		// ModelView.print(array);
		//
		// System.out.println();
		// MergeSort merge = new MergeSort(array);
		// ModelView.print(merge);
		//
		// System.out.println();
		// QuickSort s = new QuickSort(array);
		// ModelView.print(s);
		//
		// System.out.println();
		// SelectionSort selection = new SelectionSort(array);
		// ModelView.print(selection);

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

		Printable quick = new QuickSort();
		Method[] methods = quick.getClass().getMethods();

		for (Method method : methods) {
			MethodInvocation annos = method.getAnnotation(MethodInvocation.class);
			if (annos != null) {
				try {
					method.invoke(quick);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}
}
