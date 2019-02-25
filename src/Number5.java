import java.util.Scanner;

public class Number5 {

	public static void main(String[] args) {
		EquationBinaryTree mathFormula = new EquationBinaryTree();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Choose prefix, postfix, or infix: ");
		String type = scan.nextLine();
		
		System.out.println("Enter the formula you wish to convert: ");
		String formula = scan.nextLine();
		scan.close();
		
		if(type.equals("infix"))
			mathFormula.populateFromInfix(formula);
		else if(type.equals("postfix"))
			mathFormula.populateFromPostfix(formula);
		else if(type.equals("prefix"))
			mathFormula.populateFromPrefix(formula);
		else
			System.out.println("Error, improper formula entered.");
		System.out.println("Infix: ");
		mathFormula.printInfix();
		System.out.println("Postfix: ");
		mathFormula.printPostfix();
		System.out.println("Prefix: ");
		mathFormula.printPrefix();
	}
}