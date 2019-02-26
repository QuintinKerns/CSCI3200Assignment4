import java.util.Scanner;

public class Number5 {

	public static void main(String[] args) {
		EquationBinaryTree expression = new EquationBinaryTree();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Type prefix, postfix, or infix: ");
		String fix = scan.nextLine();
		
		System.out.println("Enter math formula: ");
		String formula = scan.nextLine();
		scan.close();
		
		if(fix.equals("infix"))
			expression.populateFromInfix(formula);
		else if(fix.equals("postfix"))
			expression.populateFromPostfix(formula);
		else if(fix.equals("prefix"))
			expression.populateFromPrefix(formula);
		else
			System.out.println("Error. Please try again");
		System.out.println("Infix: ");
		expression.printInfix();
		System.out.println("Postfix: ");
		expression.printPostfix();
		System.out.println("Prefix: ");
		expression.printPrefix();
	}
}