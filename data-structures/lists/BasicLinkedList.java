package lists;

/**
 * BasicLinkedList
 */
public class BasicLinkedList <T> implements IList <T> {

	private Node first;
	private Node last;
	private int nodeCount;

	public BasicLinkedList() { 
		first = null;
		last = null;
		nodeCount = 0;
	}

	@Override
	public void add(T item) {
		// create a node item
		Node node = new Node(item);

		// if this is the first node item, 
		// set the first node and return
		if (first == null) {
			first = node;
			last = node;
		}

		// if it isn't the first node
		// update the last node
		// then set it to the new node
		else { 
			last.setNextNode(node);
			last = node;
		}

		// update the count of node
		nodeCount++;
	}

	@Override
	public T remove() {
		if (first == null) { 
			throw new IllegalStateException("There are no items in the list");
		}
		T nodeItem = first.getNodeItem();
		first = first.getNextNode();
		nodeCount--;
		return nodeItem;
	}

	@Override
	public void insert(T item, int position) {
		// out of bounds position
		if (position > size()) { 
			throw new IllegalStateException("The requested position is greater than the number in the list");
		}

		Node currentNode = first;

		for (int i = 1; i < position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}

		Node newNode = new Node(item);
		Node nextNode = currentNode.getNextNode();
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nodeCount++;
	}

	@Override
	public T removeAt(int position) {
		// out of bounds position
		if (first == null) { 
			throw new IllegalStateException("The list is empty");
		}
		
		Node currentNode = first;
		Node previousNode = null;

		for (int i = 1; i < position && currentNode != null; i++) {
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}

		T item = currentNode.getNodeItem();
		previousNode.setNextNode(currentNode.getNextNode());
		nodeCount--;
		return item;
	}

	@Override
	public int find(T item) {
		if (first == null) { 
			throw new IllegalStateException("List is empty");
		}
		Node currentNode = first;
		for (int i = 1; i < size() && currentNode != null; i++) { 
			if (currentNode.getNodeItem().equals(item)) { 
				return i;
			}
			currentNode = currentNode.getNextNode();
		}

		return -1; 
	}

	@Override
	public T get(int position) {
		// out of bounds position
		if (position > size()) { 
			throw new IllegalStateException("The requested position is greater than the number in the list");
		}

		Node currentNode = first;

		for (int i = 1; i < size() && currentNode != null; i++) {
			if (i == position) {
				return currentNode.getNodeItem();
			}
			currentNode = currentNode.getNextNode();
		}

		return null;
	}

	@Override
	public int size() {
		return nodeCount;
	}

	@Override
	public String toString() { 
		StringBuffer buffer = new StringBuffer();
		Node currentNode = first;

		while (currentNode != null) { 
			buffer.append(currentNode.getNodeItem());
			currentNode = currentNode.getNextNode();
			if (currentNode != null) { 
				buffer.append(", ");
			}
		}

		return buffer.toString();
	}


	/**
	 * Private class to manage Nodes in the list
	 */
	private class Node { 
		private Node nextNode;
		private T nodeItem;

		public Node(T item) {
			this.nextNode = null;
			this.nodeItem = item;
		}

		/**
		 * @return the nodeItem
		 */
		public T getNodeItem() {
			return nodeItem;
		}

		/**
		 * @return the nextNode
		 */
		public Node getNextNode() {
			return nextNode;
		}

		/**
		 * @param nextNode the nextNode to set
		 */
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}


	}

}