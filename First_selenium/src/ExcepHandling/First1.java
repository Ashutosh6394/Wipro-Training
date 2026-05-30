package ExcepHandling;

public class First1 {
	public static void main(String[] args) {
		
		System.out.println(2/0);	

		try{
			int a=2/0;
			System.out.println("Division errorm = " + a );
		
		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println("Program continues...");
		
		
		
	}
	

}
	
