COMP 313/413 Project 2 Report Template

TestList.java and TestIterator.java

	TODO also try with a LinkedList - does it make any difference?

		No, there is no functional difference between ArrayList and LinkedList for the basic operations tested (add, contains, get, remove, etc.). Both implement the List interface and behave identically from a functionality perspective. The only differences are in performance characteristics.

TestList.java

	testRemoveObject()

		list.remove(5); // what does this method do?

			This removes the element at INDEX 5 (zero-based indexing). It removes whatever element is at position 5 in the list, regardless of the element's value.

		list.remove(Integer.valueOf(5)); // what does this one do?

			This removes the first occurrence of the VALUE 5 from the list. It searches through the list for an element equal to 5 and removes the first one found.

TestIterator.java

	testRemove()

		i.remove(); // what happens if you use list.remove(77)?

			Using list.remove(Integer.valueOf(77)) during iteration would cause a ConcurrentModificationException because you are modifying the list structure while iterating over it. The iterator's remove() method is the safe way to remove elements during iteration.

TestPerformance.java

	State how many times the tests were executed for each SIZE (10, 100, 1000 and 10000)
	to get the running time in milliseconds and how the test running times were recorded.

	The tests were executed with varying REPS values to keep runtime reasonable:
	- SIZE 10: 1,000,000 repetitions
	- SIZE 100: 100,000 repetitions
	- SIZE 1000: 10,000 repetitions
	- SIZE 10000: 1,000 repetitions

	Running times were recorded using System.currentTimeMillis() before and after each test operation.

	SIZE 10 (1,000,000 reps)
								  #1
        testArrayListAddRemove:  63 ms
        testLinkedListAddRemove: 25 ms
		testArrayListAccess:     12 ms
        testLinkedListAccess:    19 ms

	SIZE 100 (100,000 reps)
								  #1
        testArrayListAddRemove:  9 ms
        testLinkedListAddRemove: 2 ms
		testArrayListAccess:     1 ms
        testLinkedListAccess:    4 ms

	SIZE 1000 (10,000 reps)
								  #1
        testArrayListAddRemove:  2 ms
        testLinkedListAddRemove: 0 ms
		testArrayListAccess:     1 ms
        testLinkedListAccess:    3 ms

	SIZE 10000 (1,000 reps)
								  #1
        testArrayListAddRemove:  2 ms
        testLinkedListAddRemove: 0 ms
		testArrayListAccess:     0 ms
        testLinkedListAccess:    1 ms

	listAccess - which type of List is better to use, and why?

		ArrayList is better for access operations. ArrayList provides O(1) random access time because it uses an underlying array structure where elements can be accessed directly by index. LinkedList requires O(n) time for access operations because it must traverse the list from the beginning to reach the desired index. This performance difference becomes more significant as list size increases.

	listAddRemove - which type of List is better to use, and why?

		LinkedList is better for add/remove operations at the beginning of the list. LinkedList provides O(1) time for adding/removing at the head because it only needs to update pointer references. ArrayList requires O(n) time for add/remove operations at index 0 because all existing elements must be shifted to make room or fill the gap. The performance difference is clearly shown in the test results where LinkedList consistently outperforms ArrayList for these operations.