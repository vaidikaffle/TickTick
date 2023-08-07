package vaidikappiumtraining;

import java.util.ArrayList;

public class JavaArrayList {

	public static void main(String[] args) {
		
		//We use it because it dynamically increases length of the Array
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("vaidik");
		a.add("Soni");
		a.add("Java");
		a.add("Training");
		System.out.println(a.get(2));
		System.out.println(a.get(1));
		System.out.println(a.get(3));
		System.out.println(a.get(4));
		
	}

}
 