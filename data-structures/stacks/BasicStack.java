package stacks;

public class BasicStack <T> {

	private T [] data;
	private int pointer = 0;

	@SuppressWarnings("unchecked")
	public BasicStack() {
		// not great to initialize to a hardcoded value
		// this is just for practice sake
		data = (T[]) new Object[1000];
	}

	public void push(T item) {
		data[pointer++] = item;
	}

	public T pop() { 
		if (pointer == 0) { 
			throw new IllegalStateException("No more items in the BasicStack.");
		}
		return data[--pointer];
	}

	public boolean contains(T item) { 
		for (int i = 0; i < pointer; i++) { 
			if (data[i].equals(item)) return true;
		}
		return false;
	}

	public T access(T item) { 
		while (pointer > 0) { 
			T temp = pop();
			if (temp.equals(item)) return temp;
		}
		throw new IllegalStateException("No more items in the BasicStack.");
	}

	public int size() { 
		return pointer;
	}

}