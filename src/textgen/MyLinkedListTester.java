/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try {
			shortList.add(null);
		}
		catch (NullPointerException e) {
			
		}
		
		longerList.add(5);
		assertEquals("Add: check data in the last node is 5", (Integer)5, longerList.get(10));
		assertEquals("Add: check size of the list after add", 11, longerList.size());
		assertEquals("Add: check if the new node is the tail", (Integer)5, longerList.tail.data);
		assertEquals("Add: check if the previous last node is connected to the new node", (Integer)9, longerList.get(9));
		
		emptyList.add(1);
		assertEquals("Add: check if the head is the new node", (Integer)1, emptyList.head.data);
		assertEquals("Add: check if the tail is the new node", (Integer)1, emptyList.tail.data);
		emptyList.add(2);
		assertEquals("Add: check if the head is linked to new node", (Integer)2, emptyList.head.next.data);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size of empty list should be 0", 0, emptyList.size());
		assertEquals("Size of shortList should be 2", 2, shortList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			list1.add(2, null);
		}
		catch (NullPointerException e) {
			
		}
		try {
			list1.add(3, 4);
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		list1.add(1, 4);
		assertEquals("Add: check value of node with index 1", (Integer)4, list1.get(1));
		assertEquals("Add: check value of node after the new node", (Integer)21, list1.get(2));
		assertEquals("Add: check new size", 4, list1.size());
		
		longerList.add(1, 4);
		longerList.remove(5);
		longerList.add(9, 6);
		assertEquals("Add: check new size", 11, longerList.size());
		
		emptyList.add(0, 1);
		emptyList.remove(0);
		emptyList.add(0, 1);
		assertEquals("Add: check new size", 1, emptyList.size());
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			emptyList.set(0, 1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			shortList.set(-1, "A");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.set(2, "A");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		list1.set(1, 4);
		assertEquals("Set: check value of node with index 1", (Integer)4, list1.get(1));
		assertEquals("Add: check value of node after the new node", (Integer)42, list1.get(2));
		assertEquals("Add: check new size", 3, list1.size());
		
	}
	
	
	// TODO: Optionally add more test methods.
	
}
