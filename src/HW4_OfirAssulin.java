//Ofir Assulin 312299647

public class HW4_OfirAssulin {

	private final static int EXCLUDE_NUMBER = 0;

	public static void main(String[] args) {

	// Test Question 1 
		System.out.println(dec2Bin(270));
		System.out.println(bin2Dec(100001110));
		System.out.println(hex2Dec("EFD1"));
		System.out.println(dec2Hex(61393));
		System.out.println();

	// 	Test Question 2 
		int[] set = new int[] { 1, 2, 3};
		int[] subset = new int[set.length];
		System.out.print("Array: ");
		printArray(set);
		System.out.println("Subsets of array: ");
		subset(set, subset, 0);
		System.out.println();

	 //Test Question 3 
		specialPrint("Hello", '$');
	}

	/* Question 1.1 */
	// A method which converts a decimal number to binary number using recursion
	private static int dec2Bin(int num) {
		if (num == 0) {
			return 0;
		}
		return dec2Bin(num/2)*10+num%2;
	}

	/* Question 1.2 */
	// A method which converts a binary number to decimal number using recursion
	private static int bin2Dec(int num) {
		if (num == 0) {
			return 0;
		}
		return bin2Dec(num/10)*2+num%10;
	}

	/* Question 1.3 */
	// A method which converts an hexadecimal number to decimal number using recursion
	private static int hex2Dec(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		return hex2Dec(str.substring(0, str.length()-1))*16+((int)str.charAt(str.length()-1)>57 ? ((int)str.charAt(str.length()-1)-55):((int)str.charAt(str.length()-1))-48);
	}

	/* Question 1.4 */
	// A method which converts a decimal number to hexadecimal number using recursion
	private static char[] hexaMap = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	private static String dec2Hex(int num) {
		if (num < 16) {
			return "" + hexaMap[num];
		}
		return dec2Hex(num/16)+hexaMap[num%16]; 
	}

	/* Question 2 */
	// Helper - prints an array except of EXCLUDE NUMBER
	private static void printArray(int[] arr) {
		System.out.print('{');
		printArray(arr, 0, true);
		System.out.println('}');
	}

	private static void printArray(int[] arr, int index, boolean isFirst) {
		if (index >= arr.length) {
			return;
		}
		if (arr[index] != EXCLUDE_NUMBER) {
			if (isFirst) {
				System.out.printf("%d", arr[index]);
			} else {
				System.out.printf(", %d", arr[index]);
			}
			isFirst = false;

		}
		printArray(arr, index + 1, isFirst);
	}
	// A method which identifies and prints all possible subsets of a string
	private static void subset(int[] set, int[] subset, int idx) {
		if (idx == set.length) {
			printArray(subset);
			return;
		}
		subset(set, subset, idx+1);
		subset[idx] = set[idx];
		subset(set, subset, idx+1);
		subset[idx] = 0;
	}

	/* Question 3 */
	//this method receives a string and a delimiter and returns the string with the delimiter between its characters
	//if the length of the string is 1, the delimiter won't be printed with the returned character
	private static void specialPrint(String str, char delimeter) {
		if (str == null || str.length() == 0) {
			return;
		}
		specialPrint(str.substring(0, str.length() - 1), delimeter);
		if (str.length()==1){
			System.out.print(str.charAt(str.length() - 1));
		}else
		System.out.print((delimeter+""+str.charAt(str.length() - 1)));
		}
		
	
	}


