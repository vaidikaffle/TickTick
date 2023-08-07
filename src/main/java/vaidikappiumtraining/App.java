package vaidikappiumtraining;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	int num =3;
    	String name = "vaidik";
    	char latter = 'a';
    	double dec = 4.99;
    	boolean myCard = true;
    	
        System.out.println(name);
        
       //Arrays------
        
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 10;
        arr[3] = 4;
        arr[4] = 5;
        
        int[] arr2 = {1,2,3,4,5};
        System.out.println(arr[2]);
        
        for(int i=0; i<arr.length; i++) {
        	System.out.println(arr[i]);
        }
        
        String[] Name = {"Vaidik", "Rahul", "Gaurav"};
        for(int i=0; i<Name.length; i++) {
        	System.out.println(Name[i]);
        }
        
        //Enhanced for loop
        for(String s : Name) {
        	System.out.println(s);
        }
        for(int Num : arr2) {
        	System.out.println(Num);
        }
    }
}
