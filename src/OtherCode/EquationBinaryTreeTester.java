package OtherCode;

import java.util.Scanner;

public class EquationBinaryTreeTester {

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
			System.out.println("Error, imporper formula entered.");
		System.out.println(mathFormula.toInfix());
		System.out.println();
		System.out.println(mathFormula.toPostfix());
		System.out.println(mathFormula.toPrefix());
	}
}