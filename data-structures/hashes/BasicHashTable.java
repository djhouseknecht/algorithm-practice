package hashes;

/**
 * BasicHashTable
 */
public class BasicHashTable <X, Y> implements IBasicHashTable <X, Y> {
	private HashEntry[] data;
	private int capacity; //max size
	private int size; //actual size

	public BasicHashTable(int tableSize) { 
		this.capacity = tableSize;
		this.data = new HashEntry[tableSize];
		this.size = 0;
	}

	@Override
	public void put(X key, Y value) {
		int hash = calculateHash(key);

		data[hash] = new HashEntry<X,Y>(key, value);
		size++;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Y get(X key) {
		int hash = calculateHash(key);

		// if we don't have anything in that key
		if (data[hash] == null) { 
			return null;
		} 
		// else, return that value
		else { 
			return (Y) data[hash].getValue();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Y delete(X key) {
		//first get the value for this key
		Y value = get(key);

		if (value != null) { 
			int hash = calculateHash(key);
			data[hash] = null;
			size--;

			// see if the next slot is full
			hash = (hash + 1) % this.capacity;

			// if the next slot isn't empty we should readd it so we can keep the hash algorithms clean
			while (data[hash] != null) {
				HashEntry he = data[hash];
				data[hash] = null;
				put((X) he.getKey(), (Y) he.getValue());
				// we repositioned the hash item and didn't really add a new one so back off the size
				size--;
				// see if the next slot is full
				hash = (hash + 1) % this.capacity;
			}
		}

		return value;		
	}

	@Override
	public boolean hasKey(X key) {
		return get(key) != null;
	}

	@Override
	public boolean hasValue(Y value) {
		boolean found = false;

		for (HashEntry he : data) { 
			if (he != null && he.getValue().equals(value)) { 
				found = true;
				break;
			}
		}

		return found;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int capacity() {
		return this.capacity;
	}

	private int calculateHash(X key) { 
		int hash = (key.hashCode() % this.capacity);
		// this is necessary to deal with collisions
		while (data[hash] != null && !data[hash].getKey().equals(key)) { 
			hash = (hash + 1) % this.capacity;
		}
		return hash;
	}

	/* private class to hold each entry */
	private class HashEntry<X, Y> { 
		private X key;
		private Y value;

		public HashEntry(X key, Y value) { 
			this.key = key;
			this.value = value;
		}

		public X getKey() {
			return key;
		}

		public void setKey(X key) {
			this.key = key;
		}

		public Y getValue() {
			return value;
		}

		public void setValue(Y value) {
			this.value = value;
		}
	}
}