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
		if (leftIndex > 0 && rightIndex < array.length) {
			for (int i = 0; i < rightIndex; i++) {
				int menor = achaMenor(array, i, rightIndex);
				Util.swap(array, menor, i);
			}
		}
	}

	public int achaMenor(T[] array, int leftIndex, int rightIndex) {
		int menor = leftIndex;
		for (int j = leftIndex + 1; j < rightIndex; j++) {
			if (array[j].compareTo(array[menor]) > 0) menor = j;
		}
		return menor;
	}
}
