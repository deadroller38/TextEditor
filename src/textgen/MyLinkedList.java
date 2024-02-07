package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		/*head = new LLNode<E> (null);
		tail = new LLNode<E> (null);
		head.next = tail;
		tail.prev = head;*/
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> newNode = new LLNode<E> (element);
		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = tail.next;
			if (size == 1) {
				head.next = newNode;
			}
		}
		size += 1;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index >= size || index < 0 || size == 0) {
			throw new IndexOutOfBoundsException();
		}
		if (size / 2 >= index) {
			int i = 0;
			LLNode<E> findNode = head;
			while (i != index) {
				findNode = findNode.next;
				i += 1;
			}
			return findNode.data;
		} else {
			int i = size-1;
			LLNode<E> findNode = tail;
			while (i != index) {
				findNode = findNode.prev;
				i -= 1;
			}
			return findNode.data;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		if ((index >= size && size != 0) || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (size <= 1) {
			add(element);
		} else {
			LLNode<E> newNode = new LLNode<E> (element);
			if (size / 2 >= index) {
				int i = 0;
				LLNode<E> findNode = head;
				while (i != index) {
					findNode = findNode.next;
					i += 1;
				}
				newNode.next = findNode;
				if (index != 0) {
					newNode.prev = findNode.prev;
					LLNode<E> prevNode = findNode.prev;
					prevNode.next = newNode;
					findNode.prev = newNode;
				} else {
					head = newNode;
					findNode.prev = newNode;
				}
			} else {
				int i = size-1;
				LLNode<E> findNode = tail;
				while (i != index) {
					findNode = findNode.prev;
					i -= 1;
				}
				newNode.next = findNode;
				newNode.prev = findNode.prev;
				LLNode<E> prevNode = findNode.prev;
				prevNode.next = newNode;
			}
		size +=1;
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index >= size || index < 0 || size == 0) {
			throw new IndexOutOfBoundsException();
		}
		E res = get(index);
		if (size == 1 && index == 0) {
			res = get(0);
			head = tail = null;
			size = 0;
			return res;
		} else {
			if (size / 2 >= index) {
				int i = 0;
				LLNode<E> findNode = head;
				while (i != index) {
					findNode = findNode.next;
					i += 1;
				}
				LLNode<E> nextNode = findNode.next;
				if (index != 0) {
					LLNode<E> prevNode = findNode.prev;
					nextNode.prev = prevNode;
					prevNode.next = nextNode;
				} else {
					nextNode.prev = null;
					head = nextNode;
				}
			} else {
				int i = size-1;
				LLNode<E> findNode = tail;
				while (i != index) {
					findNode = findNode.prev;
					i -= 1;
				}
				LLNode<E> prevNode = findNode.prev;
				if (index != size -1) {
					LLNode<E> nextNode = findNode.next;
					nextNode.prev = prevNode;
					prevNode.next = nextNode;
				} else {
					prevNode.next = null;
					tail = prevNode;
				}
			}
		size -= 1;
		}
		
		return res;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index >= size || index < 0 || size == 0) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		E res;
		if (size / 2 >= index) {
			int i = 0;
			LLNode<E> findNode = head;
			while (i != index) {
				findNode = findNode.next;
				i += 1;
			}
			res = findNode.data;
			findNode.data = element;
			return res;
		} else {
			int i = size-1;
			LLNode<E> findNode = tail;
			while (i != index) {
				findNode = findNode.prev;
				i -= 1;
			}
			res = findNode.data;
			findNode.data = element;
			return res;
		}
		
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
