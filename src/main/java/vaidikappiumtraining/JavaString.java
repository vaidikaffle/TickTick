package vaidikappiumtraining;

public class JavaString {

	public static void main(String[] args) {
		
		// String is an object that represents sequence of characters
		// String is allocated in two ways
		
		//1. String literal
		String s = "Appium Training";
		String s1 = "Appium Training";
		String s2 = "Hello";
		
		//2. "new" memory allocator operator
		String s3 = new String("Welcome");
		String s4 = new String("Welcome");
		
		// split string into StringArray
		String s5 = "Appium Java Training";
		String[] splittedString = s5.split(" ");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[2]);
		
		String[] SplitS = s5.split("Java");
		System.out.println(SplitS[0]);
		System.out.println(SplitS[1]);
		System.out.println(SplitS[0].trim());
		
		//Print String into Characters
		for(int i=0; i<s5.length(); i++) {
			System.out.println(s5.charAt(i));
		}
		
		//Reverse String
		for(int i=s5.length()-1; i>=0; i--) {
			System.out.println(s5.charAt(i));
		}
	}

}
