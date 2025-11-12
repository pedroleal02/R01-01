package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > 0 && rightIndex < array.length) {
			for (int i = 0; i < rightIndex; i++) {
				for (int j = 0; j < rightIndex - (i+1); j++) {
					if (array[j].compareTo(array[j+1]) > 0) {
						swap(array, j, j+1);
					}
				}
			}
		}
	}

	public void swap(T[] array, int index1, int index2) { // modificar para puxar o swap do pacote util
		T aux = array[index1];
		array[index1] = array[index2];
		array[index2] = aux;
	}	
}
