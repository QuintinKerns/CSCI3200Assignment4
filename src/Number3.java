public class Number3 {
	public static void main(String[] args) {
		BinarySearchTree<Integer> btree = new BinarySearchTree<Integer>();
		int[] valv = new int[]{1,4,5,7,8,3};
		for (int i : valv){
			btree.insert(i);
		}
		btree.printInLevelOrder();
	}
}
