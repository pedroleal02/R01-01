package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean canSort = true;

		if (array == null || array.length == 0) canSort = false;
		if (leftIndex < 0 || rightIndex >= array.length) canSort = false;

		if (canSort && leftIndex < rightIndex) {
			if (leftIndex < rightIndex) {
				int minorIndex = getMinimumIndex(array, leftIndex, rightIndex);
				Util.swap(array, minorIndex, leftIndex);
				sort(array, leftIndex + 1, rightIndex);
			}
		}
	}

	public int getMinimumIndex(T[] array, int leftIndex, int rightIndex) {
		int minor = leftIndex;
		if (leftIndex < rightIndex) {
			int nextMinor = getMinimumIndex(array, leftIndex + 1, rightIndex);
			if (array[nextMinor].compareTo(array[minor]) < 0) minor = nextMinor;
		}
		return minor;
	}

}
