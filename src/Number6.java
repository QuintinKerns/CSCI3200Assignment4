import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Number6 {
	static Scanner scan = new Scanner(System.in);
	static TreeMap map;

	public static void main(String[] args) {
		map = new TreeMap();
		askForName();
		while (map.size() > 0){
			Entry e = map.firstEntry();
			System.out.println("Key: " + e.getKey() + ", Value: " + e.getValue());
			map.remove(e.getKey(), e.getValue());
		}
	}
	
	private static void askForName(){
		System.out.println("Please enter a name: ");
		String name = scan.nextLine();
		int vowels = 0;
		for (char c : name.toCharArray()){
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels++;
		}
		map.put(name, vowels);
		System.out.println("Press enter to continue, type no to quit:");
		String response = scan.nextLine();
		if (response.equals("")) askForName();
	}

}
