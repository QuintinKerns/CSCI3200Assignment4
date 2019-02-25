public class EquationBinaryTree {
	private Node root;

	public EquationBinaryTree()
	{
		root = null;
	}


	//(left parent right)
	//(->left->parent->right->)
	public void printInfix()
	{
		printInfixHelper(root);
		System.out.println();
	}
	private void printInfixHelper(Node n)//O(N) - visit each node only once
	{
		if(n != null && n.left != null)
		{
			System.out.print("(");
			printInfixHelper(n.left);//left side
			System.out.print(n.value);//middle item//parent
			printInfixHelper(n.right);//right side
			System.out.print(")");
		}
		else if(n != null)
		{
			System.out.print(n.value);//middle item//parent
		}
	}
	//left -> right -> parent
	public void printPostfix()
	{
		printPostfixHelper(root);
		System.out.println();
	}
	private void printPostfixHelper(Node n)
	{
		if(n != null && n.left != null)
		{
			printPostfixHelper(n.left);//left side
			printPostfixHelper(n.right);//right side
			System.out.print(n.value);//middle item//parent
		}
		else if(n != null)
		{
			System.out.print(n.value);//middle item//parent
		}
	}
	//parent -> left -> right
	public void printPrefix()
	{
		printPrefixHelper(root);
		System.out.println();
	}
	private void printPrefixHelper(Node n)
	{
		if(n != null && n.left != null)
		{
			System.out.print(n.value);//middle item//parent
			printPrefixHelper(n.left);//left side
			printPrefixHelper(n.right);//right side
		}
		else if(n != null)
		{
			System.out.print(n.value);//middle item//parent
		}
	}

	//(a+b)
	//(a+(b*c))
	//((a*b)+c)
	public void populateFromInfix(String equation)
	{
		root = populateFromInfixHelper(equation);
	}
	public Node populateFromInfixHelper(String equation)
	{
		if(equation.length() == 1)
		{
			return new Node(equation);//math operand
		}

		//System.out.println(equation);
		String temp = equation.substring(1, equation.length()-1);//remove wrapper paren

		//begin search for middle of equation
		int parenCount = 0;
		int mid = 0;
		for(int i = 0; i < temp.length(); i++)
		{
			if(temp.charAt(i) == '(')
				parenCount++;
			if(temp.charAt(i) == ')')
				parenCount--;
			if(parenCount == 0)
			{
				mid = i+1;
				break;
			}
		}
		//middle
		Node n = new Node(""+temp.charAt(mid));
		//first half
		n.left = populateFromInfixHelper(temp.substring(0, mid));
		//System.out.println(temp.substring(0, mid));
		//second half
		n.right = populateFromInfixHelper(temp.substring(mid+1));
		//System.out.println(temp.substring(mid+1));

		return n;
	}
	//ab+ = (a+b)
	public void populateFromPostfix(String post)
	{
		root = populateFromPostfixHelper(post);
	}
	private Node populateFromPostfixHelper(String post)
	{
		String[] parts = postfixBreakdownHelper(post);
		Node temp = new Node(post.charAt(post.length() - 1) + "");
		if(parts[0].length() == 1)
			{
				temp.left = new Node(parts[0].charAt(0) + "");
			}
		else
			{
				temp.left = populateFromPostfixHelper(parts[0]);
			}

		if(parts[2].length() == 1)
			{
				temp.right = new Node(parts[2].charAt(0) + "");
			}
		else
			{
				temp.right = populateFromPostfixHelper(parts[2]);
			}
		
		return temp;
	}
	private String[] postfixBreakdownHelper(String post)
	{
		String[] temp= new String[3];
		int pos = 0;
		int count = 1;
		for(int i = 0; i < post.length() - 1; i++)
		{
			if(post.charAt(i) == '+' || post.charAt(i) == '*')
				count++;
			else
				count--;
			if(i > 0 && count == 0)
				{
					pos = i;
					break;
				}
		}
		
		temp[0] = post.substring(0, pos + 1);
		temp[1] = "" + post.charAt(post.length() - 1);
		temp[2] = post.substring(pos + 1, post.length() - 1);
		
		return temp;
	}
	
	//+ab = (a+b)
	public void populateFromPrefix(String pre)
	{
		root = populateFromPrefixHelper(pre);
	}

	private Node populateFromPrefixHelper(String pre)
	{
		String[] parts = prefixBreakdownHelper(pre);
		Node temp = new Node(pre.charAt(0) + "");
		if(parts[0].length() == 1) {
				temp.left = new Node(parts[0].charAt(0) + "");
			}
		
		else {
				temp.left = populateFromPrefixHelper(parts[0]);
			}

		if(parts[2].length() == 1) {
				temp.right = new Node(parts[2].charAt(0) + "");
			}
		
		else {
				temp.right = populateFromPrefixHelper(parts[2]);
			}
		
		return temp;
	}

	private String[] prefixBreakdownHelper(String pre)
	{
		String[] temp= new String[3];
		int pos = 0;
		int count = 1;
		for(int i =1; i < pre.length(); i++)
			{
				if(pre.charAt(i) == '+' || pre.charAt(i) == '*')
					count++;
				else
					count--;
				if(count == 0)
				{
					pos = i;
					break;
				}
			}
		
		temp[0] = pre.substring(1, pos + 1);
		temp[1] = "" + pre.charAt(0);
		temp[2] = pre.substring(pos + 1, pre.length());
		
		return temp;
	}

	private class Node
	{
		String value;
		Node left, right;
		public Node(String v)
		{
			value = v;
			left = null;
			right = null;
		}
	}
}
