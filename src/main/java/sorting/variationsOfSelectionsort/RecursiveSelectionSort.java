package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

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
		if (leftIndex > 0 && rightIndex < array.length) {
			System.out.println("fazer");
		}
	}

	public int minor(T[] array, int leftIndex, int rightIndex) {
		int minor = leftIndex;
		int returnedValue;
		if (leftIndex < rightIndex) {
			if (array[leftIndex].compareTo(array[leftIndex+1]) < 0) {
				minor = leftIndex+1;
			}
			returnedValue = minor(array, leftIndex+1, rightIndex);
		}
		returnedValue = minor;
		return returnedValue;
	}

	/*@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > 0 && rightIndex < array.length) {
			for (int i = 0; i < rightIndex; i++) {
				int menor = achaMenor(array, i, rightIndex);
				swap(array, menor, i);
			}
		}
	}*/

}
