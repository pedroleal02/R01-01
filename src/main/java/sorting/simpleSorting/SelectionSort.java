package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean canSort = true;

		if (array == null || array.length == 0) canSort = false;
		if (leftIndex < 0 || rightIndex >= array.length || leftIndex > rightIndex) canSort = false;

		if (canSort && leftIndex < rightIndex) {
			for (int i = leftIndex; i < rightIndex; i++) {
				int minorIndex = getMinimumIndex(array, i, rightIndex);
				Util.swap(array, i, minorIndex);
			}
		}
	}

	public int getMinimumIndex(T[] array, int leftIndex, int rightIndex) {
		int minor = leftIndex;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(array[minor]) < 0) minor = i;
		}
		return minor;
	}
}
