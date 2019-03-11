package lists;

/**
 * IList
 */
public interface IList <T> {

	public void add(T item);

	public T remove();

	public void insert(T item, int position);

	public T removeAt(int position);

	public int find(T item);

	public T get(int position);

	public int size();
}

/* 
- _add_: Add an item to the list _`O(1)`_
- _remove_: Remove an item from the list _`O(1)`_
- _insert_: Insert an item to the list at a specific index _`O(n)`_
- _removeAt_: Remove an item at a specific index _`O(n)`_
- _find_: Find a specific item _`O(n)`_
- _get_: Get an item at a specific index _`O(n)`_
 */