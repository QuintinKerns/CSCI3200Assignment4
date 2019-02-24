
public class Number4 {

	public static void main(String[] args) {
		BinarySearchTree<Integer> btree = new BinarySearchTree<Integer>();
		int[] vals = new int[]{1,4,5,7,8,3};
		for (int i : vals){
			btree.insert(i);
		}
		
		BinarySearchTree<Integer> btree2 = new BinarySearchTree<Integer>();
		int[] vals2 = new int[]{1,4,5,7,8,3};
		for (int i : vals2){
			btree2.insert(i);
		}
		
		// Test Code
		System.out.println("Are Identical: " + btree.visuallyIdentical(btree2));
		btree2.insert(12);
		System.out.println("Are Identical: " + btree.visuallyIdentical(btree2));
	}

}
