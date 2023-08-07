package vaidikappiumtraining;

public class JavaConditionalStatements {

	public static void main(String[] args) {
		

		 int[] arr2 = {1,2,3,4,5,12,23,50};
		 
		 //print values multiple of 2
		 
		 for(int i=0; i<arr2.length; i++) {
			 if(arr2[i] % 2 == 0) {
				 System.out.println(arr2[i]);
				 break;
			 }
			 else {
				 System.out.println(arr2[i] + " is not multiple of 2");
			 }
			 
			 
		 }
	}

}
