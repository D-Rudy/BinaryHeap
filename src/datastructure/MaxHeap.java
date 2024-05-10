package datastructure;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

	public MaxHeap(Class<T> clazz) {

		super(clazz);
	}

	@Override
	protected void siftDown(int index) {

		System.out.println("siftDown " + getElementAtIndex(index));

		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChild(index);

		// trouver le plus grand des éléments leftChild et rightChild
		int largerIndex = -1;

		if (leftIndex != -1 && rightIndex != -1) {

			T leftElement = getElementAtIndex(leftIndex);
			T rightElement = getElementAtIndex(rightIndex);

			largerIndex = leftElement.compareTo(rightElement) > 0 ? leftIndex : rightIndex;
		} else if (leftIndex != -1) {
			largerIndex = leftIndex;
		} else if (rightIndex != 1) {
			largerIndex = rightIndex;
		}
		// S'il n'y a pas de left ni de rightChild, on arrete
		if (largerIndex == -1) {
			System.out.println("arret de siftDown, position du noeud trouvée");
			return;
		}

		System.out.println("Le plus grand est: " + getElementAtIndex(largerIndex));

		// Comparer le plus grand à l'index courant pour voir s'il faut faire un swap ou
		// continuer siftDown
		if (getElementAtIndex(largerIndex).compareTo(getElementAtIndex(index)) > 0) {

			swap(largerIndex, index);
			System.out.println("Swap: " + this.toString());
			siftDown(largerIndex);
		}
	}

	@Override
	protected void siftUp(int index) {

		System.out.println("siftUp: " + getElementAtIndex(index));

		int parentIndex = getParentIndex(index);

		if (parentIndex == -1) {

			System.out.println("Arret de sitfDown, position trouvée");
			return;
		}

		System.out.println("Parent: " + getElementAtIndex(parentIndex));

		if (getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) > 0) {

			swap(parentIndex, index);
			System.out.println("Swap: " + this.toString());
			siftUp(parentIndex);
		}

	}

}
