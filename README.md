# Custom Data Structures

This project implements custom data structures such as ArrayList, LinkedList, Stack, Queue, and MinHeap.

## Usage

1. **MyArrayList**: Represents a custom implementation of ArrayList.
   - Create an instance: `MyArrayList<T> list = new MyArrayList<>();`
   - Add elements: `list.add(item);`
   - Access elements: `T item = list.get(index);`
   - Remove elements: `list.remove(index);`
   - Sort elements: `list.sort();`

2. **MyLinkedList**: Represents a custom implementation of Doubly Linked List.
   - Create an instance: `MyLinkedList<T> list = new MyLinkedList<>();`
   - Add elements: `list.add(item);`
   - Access elements: `T item = list.get(index);`
   - Remove elements: `list.remove(index);`
   - Sort elements: `list.sort();`

3. **MyStack**: Represents a custom implementation of Stack using LinkedList.
   - Create an instance: `MyStack<T> stack = new MyStack<>();`
   - Push elements: `stack.push(item);`
   - Pop elements: `T item = stack.pop();`
   - Peek top element: `T top = stack.peek();`

4. **MyQueue**: Represents a custom implementation of Queue using LinkedList.
   - Create an instance: `MyQueue<T> queue = new MyQueue<>();`
   - Enqueue elements: `queue.enqueue(item);`
   - Dequeue elements: `T item = queue.dequeue();`
   - Peek front element: `T front = queue.peek();`

5. **MyMinHeap**: Represents a custom implementation of MinHeap using ArrayList.
   - Create an instance: `MyMinHeap<T> heap = new MyMinHeap<>();`
   - Insert elements: `heap.insert(item);`
   - Extract minimum element: `T min = heap.extractMin();`
