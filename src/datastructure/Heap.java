package datastructure;

import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class Heap<T extends Comparable<T>> {

	private static int MAX_SIZE = 10;
	private T[] array;
	private int count = 0;

	@SuppressWarnings("unchecked")
	public Heap(Class<T> clazz) {
		array = (T[]) Array.newInstance(clazz, MAX_SIZE);
	}

	public int getCount() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == array.length;
	}

	public T getElementAtIndex(int index) {
		return array[index];
	}

	public int getLeftChildIndex(int parentIndex) {
		if (parentIndex < 0) {
			return -1;
		}
		int leftChildIndex = 2 * parentIndex + 1;
		if (leftChildIndex >= count) {
			return -1;
		}
		return leftChildIndex;
	}

	public int getRightChild(int parentIndex) {
		if (parentIndex < 0) {
			return -1;
		}
		int rightChildIndex = 2 * parentIndex + 2;
		if (rightChildIndex >= count) {
			return -1;
		}
		return rightChildIndex;
	}

	public int getParentIndex(int childIndex) {
		if (childIndex <= 0 || childIndex >= count) {
			return -1;
		}
		return (childIndex - 1) / 2;
	}

	public void swap(int index1, int index2) {
		T tempValue = array[index1];

		array[index1] = array[index2];
		array[index2] = tempValue;
	}

	protected abstract void siftDown(int index);

	protected abstract void siftUp(int index);

	public T getHigestPriority() throws HeapEmptyException {
		if (count == 0) {
			throw new HeapEmptyException("Le tas est vide!");
		}
		return array[0];
	}

	public void insert(T value) throws HeapFullException {
		if (count >= array.length) {
			throw new HeapFullException("Le tas est plein!");
		}

		array[count] = value;
		count++;

		System.out.println("Ajout de " + value + " --> " + this.toString());
		siftUp(count - 1);
	}

	public T removeHighestPriority() throws HeapEmptyException {
		T first = getHigestPriority();
		array[0] = array[count - 1];

		array[count - 1] = null;
		count--;
		siftDown(0);
		return first;
	}

	public String toString() {
		return Arrays.toString(array);
	}
}
