package trees;

/**
 * BasicBinaryTree
 */
public class BasicBinaryTree<X extends Comparable<X>> {
	private Node root;
	private int size;

	public BasicBinaryTree() {
		this.root = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public void add(X item) {
		// create a Node from the incoming item
		Node newNode = new Node(item);
		// if we don't have a root Node yet, create
		// the root Node as the incoming Node
		if (size == 0 && root == null) {
			this.root = newNode;
			this.size++;
		}
		// we do have a root node, set the incoming Node
		// on a child Node
		else {
			insert(this.root, newNode);
		}
	}

	public boolean contains(X item) {
		Node foundNode = getNode(this.root, item);

		return foundNode != null;
	}

	public boolean delete(X item) {
		if (this.root == null)
			return false;

		Node currentNode = getNode(this.root, item);

		if (currentNode == null)
			return false;

		// grad the right and left Node
		Node leftNode = currentNode.getLeft();
		Node rightNode = currentNode.getRight();

		// if it doesn't have children, just delete it
		if (leftNode == null && rightNode == null) {
			replaceNode(currentNode, null);
		}
		// if only left has a child
		else if (leftNode != null && rightNode == null) {
			replaceNode(currentNode, currentNode.getLeft());
		}
		// if only right has a child
		else if (leftNode == null && rightNode != null) {
			replaceNode(currentNode, currentNode.getRight());
		}
		// if the right and left have a child
		else {
			// select the right most child off the left node of the current node
			Node rightMostChild = currentNode.getLeft();
			while (rightMostChild.getRight() != null) {
				rightMostChild = rightMostChild.getRight();
			}

			// set the rightMostChild's parent's right Node to the
			// left node of the rightMostChild
			rightMostChild.getParent().setRight(rightMostChild.getLeft());

			// set the new child nodes for the rightMostChild
			rightMostChild.setLeft(currentNode.getLeft());
			rightMostChild.setRight(currentNode.getRight());

			// replace the nodes
			replaceNode(currentNode, rightMostChild);
		}

		size--;
		return true;
	}

	private void replaceNode(Node currentNode, Node newNode) {
		if (currentNode == this.root) {
			newNode.setLeft(currentNode.getLeft());
			newNode.setRight(currentNode.getRight());
			this.root = newNode;
		} else if (currentNode.getParent().getRight() == currentNode) {
			currentNode.getParent().setRight(newNode);
		} else {
			currentNode.getParent().setLeft(newNode);
		}
	}

	private Node getNode(Node node, X item) {
		if (node == null)
			return null;

		// int compared = node.getItem().compareTo(item);
		int compared = item.compareTo(node.getItem());

		// if the node matches, return the item
		if (compared == 0) {
			return node;
		}
		// compare the left node
		else if (compared < 0) {
			if (node.getLeft() == null)
				return null;
			return getNode(node.getLeft(), item);
		}
		// compare the right node
		else {
			if (node.getRight() == null)
				return null;
			return getNode(node.getRight(), item);
		}
	}

	private void insert(Node parent, Node child) {
		// determine if the child needs to be on the left
		if (child.getItem().compareTo(parent.getItem()) < 0) {
			// if there is no value in the left node, add this item to it
			if (parent.getLeft() == null) {
				parent.setLeft(child);
				child.setParent(parent);
				size++;
			}
			// if not, we need to recurse down the left node
			else {
				insert(parent.getLeft(), child);
			}
		}
		// determine if the child needs to be on the right
		else if (child.getItem().compareTo(parent.getItem()) > 0) {
			// if there is no value in the right node, add this item to it
			if (parent.getRight() == null) {
				parent.setRight(child);
				child.setParent(parent);
				size++;
			}
			// if not, we need to recurse down the right node
			else {
				insert(parent.getRight(), child);
			}
		}

		// if the item is the same as the item in the parent, we won't add it again
		// ie. we do nothing
	}

	/**
	 * Define a node which will be used in the Binary Tree
	 */
	@SuppressWarnings("unused")
	private class Node {
		private Node left;
		private Node right;
		private Node parent;
		private X item;

		public Node(X item) {
			this.item = item;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		/**
		 * @return the left
		 */
		public Node getLeft() {
			return left;
		}

		/**
		 * @param left the left to set
		 */
		public void setLeft(Node left) {
			this.left = left;
		}

		/**
		 * @return the right
		 */
		public Node getRight() {
			return right;
		}

		/**
		 * @param right the right to set
		 */
		public void setRight(Node right) {
			this.right = right;
		}

		/**
		 * @return the parent
		 */
		public Node getParent() {
			return parent;
		}

		/**
		 * @param parent the parent to set
		 */
		public void setParent(Node parent) {
			this.parent = parent;
		}

		/**
		 * @return the item
		 */
		public X getItem() {
			return item;
		}

		/**
		 * @param item the item to set
		 */
		public void setItem(X item) {
			this.item = item;
		}

	}
}