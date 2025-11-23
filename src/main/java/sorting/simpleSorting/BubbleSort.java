package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean canSort = true;

		if (array == null || array.length == 0) canSort = false;
		if (leftIndex < 0 || rightIndex >= array.length) canSort = false;

		if (canSort && leftIndex < rightIndex) {

			for (int i = 0; i < rightIndex - leftIndex; i++) {
				for (int j = leftIndex; j < rightIndex - i; j++) {
					if (array[j].compareTo(array[j + 1]) > 0) Util.swap(array, j, j + 1);
				}
			}
		}
	}
}
