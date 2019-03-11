package queues;

/**
 * BasicQueue
 */
public class BasicQueue<T> implements IQueue<T> {

	private T[] data;
	/* for deQueue */
	private int front;
	/* for enQueue */
	private int end;

	public BasicQueue() {
		this(1000);
	}

	@SuppressWarnings("unchecked")
	public BasicQueue(int size) {
		data = (T[]) new Object[size];
		front = -1;
		end = -1;
	}

	@Override
	public T deQueue() {
		T item = null;
		// check to see if queue is empty
		if (size() == 0) { 
			throw new IllegalStateException("BasicQueue is empty");
		}
		// check to see if it is the last value in the queue
		else if (front == end) {
			item = data[front];
			data[front] = null;
			front = -1;
			end = -1;
		}
		// if not the last item, just take the next item
		else { 
			item = data[front];
			data[front] = null;
			front++;
		}
		return item;
	}

	@Override
	public void enQueue(T item) {
		// see if queue if full
		if ((end + 1) % data.length == front) { 
			throw new IllegalStateException("BasicQueue is full");
		} 
		// if no data has been added yet
		else if (size() == 0) { 
			front++;
			end++;
			data[end] = item;
		} 
		// else just push the item to the next slot in the queue
		else {
			end++;
			data[end] = item;
		}
	}

	@Override
	public int size() {
		if (front == -1 && end == -1) {
			return 0;
		} else {
			return end - front + 1;
		}
	}

	@Override
	public boolean contains(T item) {
		for (int i = front; i < end; i++) { 
			if (data[i].equals(item)) return true;
		}
		return false;
	}

	@Override
	public T access(int position) {
		if(size() == 0 || position > size()) { 
			throw new IllegalStateException("Item not found in the BasicQueue or the requested position is greater than the amount in the BasicQueue");
		}

		int trueIndex = 0;
		for (int i = front; i < end; i++) { 
			if (trueIndex == position) { 
				return data[i];
			}
			trueIndex++;
		}
		throw new IllegalStateException("Item not found in the BasicQueue");
	}

}