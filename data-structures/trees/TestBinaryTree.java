package trees;

/**
 * TestBinaryTree
 */
public class TestBinaryTree {

	private static BasicBinaryTree<Character> tree = new BasicBinaryTree<>();

	public static void main(String[] args) {
		tree.add('C');
		tree.add('A');	
		tree.add('I');	
		tree.add('J');	
		tree.add('L');	
		tree.add('E');	
		tree.add('D');	
		tree.add('H');	
		tree.add('G');	
		tree.add('F');
		System.out.println("Added characters");
		tree.delete('I');
		System.out.println("Deleted 'I'");
	}
}