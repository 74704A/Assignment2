import java.util.NoSuchElementException;

// Implementation of a Min Heap data structure
public class MyHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap; // Internal data structure for the heap

    // Constructor to initialize the heap
    public MyHeap() {
        heap = new MyArrayList<T>(); // Initialize the internal ArrayList
    }

    // Get the element at the specified index in the heap
    public T get(int index) {
        return heap.get(index); // Retrieve element at the specified index
    }

    // Check if the heap is empty
    public boolean empty() {
        return heap.length() == 0; // Check if the internal ArrayList is empty
    }

    // Get the size of the heap
    public int size() {
        return heap.length(); // Get the number of elements in the internal ArrayList
    }

    // Extract the minimum element from the heap
    public T extractMin() {
        T min = getMin(); // Get the minimum element
        heap.remove(heap.indexOf(min)); // Remove the minimum element from the heap
        // Re-organize the heap after removal
        int startIdx = (heap.length() / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            heapify(i);
        }
        return min; // Return the extracted minimum element
    }

    // Get the minimum element from the heap
    public T getMin() {
        if (empty()) { // Check if the heap is empty
            throw new NoSuchElementException("Heap is empty"); // Throw an exception if the heap is empty
        }
        T min = heap.get(0); // Get the first element as the initial minimum
        // Find the minimum element in the heap
        for (int i = 0; i < heap.length(); i++) {
            if (min.compareTo(heap.get(i)) > 0) {
                min = heap.get(i);
            }
        }
        return min; // Return the minimum element
    }

    // Insert an element into the heap
    public void insert(T item) {
        heap.add(item); // Add the new element to the end of the heap
        traverseUp(heap.indexOf(item)); // Re-organize the heap to maintain the heap property
    }

    // Get the left child of a node at the specified index
    private T leftChildOf(int index) {
        int leftChildIndex = 2 * index + 1; // Calculate the index of the left child
        if (leftChildIndex < heap.length()) {
            return heap.get(leftChildIndex); // Return the left child if it exists
        } else {
            throw new IndexOutOfBoundsException("No left child for that index"); // Throw an exception if no left child exists
        }
    }

    // Get the right child of a node at the specified index
    private T rightChildOf(int index) {
        int rightChildIndex = 2 * index + 2; // Calculate the index of the right child
        if (rightChildIndex < heap.length()) {
            return heap.get(rightChildIndex); // Return the right child if it exists
        } else {
            throw new IndexOutOfBoundsException("No right child for that index"); // Throw an exception if no right child exists
        }
    }

    // Get the parent of a node at the specified index
    private int parentOf(int index) {
        if (index < 0 || index > heap.length()) {
            throw new IndexOutOfBoundsException("No parent for that index"); // Throw an exception if no parent exists
        }
        return index / 2; // Calculate the index of the parent
    }

    // Swap two elements in the heap
    private void swap(int index1, int index2) {
        T temp = heap.get(index1); // Temporary variable to store the element at index1
        heap.set(index1, heap.get(index2)); // Set the element at index1 to the element at index2
        heap.set(index2, temp); // Set the element at index2 to the temporary variable
    }

    // Re-organize the heap starting from the specified index
    private void heapify(int index) {
        int smallest = index; // Assume the current node is the smallest
        int leftChildIndex = 2 * index + 1; // Calculate the index of the left child
        int rightChildIndex = 2 * index + 2; // Calculate the index of the right child

        // Check if the left child is smaller than the current node
        if (leftChildIndex < heap.length() && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }

        // Check if the right child is smaller than the current node
        if (rightChildIndex < heap.length() && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }

        // If the smallest node is not the current node, swap them and continue heapifying
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    // Re-organize the heap after inserting a new element
    private void traverseUp(int index) {
        int parentIndex = parentOf(index); // Calculate the index of the parent

        // Move up the heap until the element reaches its correct position
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex); // Swap the current element with its parent
            index = parentIndex; // Update the index to the parent index
            parentIndex = parentOf(index); // Calculate the new parent index
        }
    }
}
