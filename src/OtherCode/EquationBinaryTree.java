package OtherCode;

public class EquationBinaryTree {
	private Node root;
	public EquationBinaryTree()
		{
			root = null;
		}
	
	public String toInfix()
		{
			return toInfixHelper(root);
		}
	
	private String toInfixHelper(Node node)
		{
			String output = "";
			if(node.leftChild != null)
				{
					output += "(";
					output += toInfixHelper(node.leftChild);
					output += node;
					output += toInfixHelper(node.rightChild);
					output += ")";
				}
			
			else
				{
					output += node;
				}
			
			return output;
		}
	
	public String toPostfix()
		{
			return toPostfixHelper(root);
		}
	
	private String toPostfixHelper(Node node)
		{
			String output = "";
			if(node.leftChild != null)
				{
					output += toPostfixHelper(node.leftChild);
					output += toPostfixHelper(node.rightChild);
					output += node;
				}
			
			else
				{
					output += node;
				}
			
			return output;
		}
	
	public String toPrefix()
		{
			return toPrefixHelper(root);
		}
	
	private String toPrefixHelper(Node node)
		{
			String output = "";
			if(node.leftChild != null)
				{
					output += node;
					output += toPrefixHelper(node.leftChild);
					output += toPrefixHelper(node.rightChild);
				}
			
			else
				{
					output += node;
				}
			
			return output;
		}
	
	//infix ((a-d)+(b*c))
	public void populateFromInfix(String infix)
		{
			root = populateFromInfixHelper(infix);
		}
		
	private Node populateFromInfixHelper(String infix)
		{
	
			String[] parts = infixBreakdownHelper(infix);
			Node temp = new Node(parts[1].charAt(0));
			if (parts[0].length() == 1)
				{
					 temp.leftChild = new Node(parts[0].charAt(0));
				}
			
			else
				{
					temp.leftChild = populateFromInfixHelper(parts[0]);
				}
			
			if (parts[2].length() == 1)
				{
					temp.rightChild = new Node(parts[2].charAt(0));
				}
			
			else
				{
					temp.rightChild = populateFromInfixHelper(parts[2]);
				}
			
			return temp;
		}
	private String[] infixBreakdownHelper(String infix)
	{
	
		String[] temp = new String[3];
		int pos = 0;
		int count = 0;
		for(int i = 1; i < infix.length(); i++)
		{
			if(infix.charAt(i) == '(')
				count++;
			else if(infix.charAt(i) == ')')
				count--;
			if(count == 0)
			{
				pos = i;
				break;
			}
		}

		temp[0] = infix.substring(1, pos+1);//left
		temp[1] = ""+infix.charAt(pos+1);//middle
		temp[2] = infix.substring(pos+2, infix.length()-1);//right
		return temp;
	}

	public void populateFromPrefix(String pre)
		{
			root = populateFromPrefixHelper(pre);
		}
	
	private Node populateFromPrefixHelper(String pre)
		{
			String[] parts = prefixBreakdownHelper(pre);
			Node temp = new Node(pre.charAt(0));
			if(parts[0].length() == 1)
				{
					temp.leftChild = new Node(parts[0].charAt(0));
				}
			
			else
				{
					temp.leftChild = populateFromPrefixHelper(parts[0]);
				}
	
			if(parts[2].length() == 1)
				{
					temp.rightChild = new Node(parts[2].charAt(0));
				}
			
			else
				{
					temp.rightChild = populateFromPrefixHelper(parts[2]);
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
		
	public void populateFromPostfix(String post)
		{
			root = populateFromPostfixHelper(post);
		}
	private Node populateFromPostfixHelper(String post)
		{
			String[] parts = postfixBreakdownHelper(post);
			Node temp = new Node(post.charAt(post.length() - 1));
			if(parts[0].length() == 1)
				{
					temp.leftChild = new Node(parts[0].charAt(0));
				}
			else
				{
					temp.leftChild = populateFromPostfixHelper(parts[0]);
				}
	
			if(parts[2].length() == 1)
				{
					temp.rightChild = new Node(parts[2].charAt(0));
				}
			else
				{
					temp.rightChild = populateFromPostfixHelper(parts[2]);
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

	private class Node
	{
		public Node leftChild, rightChild;
		public char data;
		public Node(char data) 
		{
			leftChild = null;
			rightChild = null;
			this.data = data;
		}
		
		public String toString()
		{
			return "" + data;
		}
	}
}