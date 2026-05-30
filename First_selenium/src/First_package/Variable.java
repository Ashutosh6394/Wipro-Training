package First_package;

public class Variable {
	
	 int globalVar = 10;
	 static int staticVar = 20;

	 void display() {
		 
	     int localVar = 30;
	       

	     System.out.println("Local Variable: " + localVar);
	     System.out.println("Global Variable: " + globalVar);
	     System.out.println("Static Variable: " + staticVar);
	     
	 }
	

	public static void main(String[] args) {
		Variable obj = new Variable();
        obj.display();

        System.out.println("Access Static Directly: " + Variable.staticVar);
       // System.out.println("Static Variable: " + Variable.localVar);
	

	}

}
