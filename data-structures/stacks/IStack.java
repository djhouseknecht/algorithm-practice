package stacks;

/**
 * Interface for a customized Stack implementation
 */
public interface IStack <T>  {

	/**
	 * Push an item onto the stack
	 * @param item the item you want to push onto the stack
	 * @return nothing
	 */
	public void push(T item);

	/**
	 * Retrive the top item of the stack
	 * @return the top item of the stack 
	 */
	public T pop();

	/**
	 * Find out if the item passed is exists on the stack. 
	 * @param item the item you are looking for in the stack
	 */
	public boolean contains(T item);

	/**
	 * Find the item passed on the stack. This is a desctructive method and will remove 
	 * 	all items on the stack until it find the passed in item or the stack is empty. 
	 * @param item the item you are looking for in the stack
	 * @return the found item in the stack
	 */
	public T access(T item);

	/**
	 * Get the current size of the statck
	 * @return the current size of the stack 
	 */
	public int size();

}