package queues;

/**
 * IQueue
 */
public interface IQueue<T> {

	public T deQueue();

	public void enQueue(T item);

	public boolean contains(T item);

	public T access(int position);

	public int size();
	
}