package hashes;

/**
 * IBasicHashTable
 */
public interface IBasicHashTable <X, Y> {

	public int size();

	public int capacity();

	public void put(X key, Y value);

	public Y get(X key);

	public Y delete(X key);

	public boolean hasKey(X key);

	public boolean hasValue(Y value);

}