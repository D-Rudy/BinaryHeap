package datastructure;

import java.util.Arrays;

public class Heapify {

	private static int getParentIndex(int index, int endIndex) {

		if (index < 0 || index > endIndex) {
			return -1;
		}

		return (index - 1) / 2;
	}

	private static int getLeftChildIndex(int index, int endIndex) {
		int leftChildIndex = 2 * index + 1;

		if (leftChildIndex > endIndex) {
			return -1;
		}

		return leftChildIndex;
	}

	private static int getRightChildIndex(int index, int endIndex) {

		int rightChildIndex = 2 * index + 2;

		if (rightChildIndex > endIndex) {
			return -1;
		}

		return rightChildIndex;
	}

	public static void swap(int[] array, int index1, int index2) {

		int tmpValue = array[index1];
		array[index1] = array[index2];
		array[index2] = tmpValue;
	}

	public static void percolateDown(int[] array, int index, int endIndex) {

		System.out.println("Filtrage vers le bas: " + array[index]);

		int leftChildIndex = getLeftChildIndex(index, endIndex);
		int rightChildIndex = getRightChildIndex(index, endIndex);

		int largerIndex = -1;

		if (leftChildIndex != -1 && rightChildIndex != -1) {

			largerIndex = array[leftChildIndex] > array[rightChildIndex] ? leftChildIndex : rightChildIndex;

		} else if (leftChildIndex != -1) {
			largerIndex = leftChildIndex;
		} else if (rightChildIndex != -1) {
			largerIndex = rightChildIndex;
		}

		if (largerIndex == -1) {
			System.out.println("Arret du filtrage");
			return;
		}
		System.out.println("Le plus grand: " + array[largerIndex]);

		if (array[largerIndex] > array[index]) {
			swap(array, largerIndex, index);

			System.out.println("Swap: " + Arrays.toString(array));

			percolateDown(array, largerIndex, endIndex);
		}
	}

	public static void heapify(int[] array, int endIndex) {
		int index = getParentIndex(endIndex, endIndex);

		System.out.println("Enfant: " + array[endIndex]);
		System.out.println("Parent: " + array[index]);

		while (index >= 0) {
			System.out.println("\nTraitement de l'index: " + index + " Tableau: " + Arrays.toString(array));
			percolateDown(array, index, endIndex);

			index--;
		}
	}
}
