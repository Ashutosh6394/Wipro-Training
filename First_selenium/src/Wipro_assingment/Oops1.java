package Wipro_assingment;


//
//public class Oops1{
//	int empid;
//	String name;
//	// static variable
//	static String companyname="Wipro";
//	void show(int empid1, String name1)
//	{
//		empid=empid1;
//		name=name1;
//	
//		System.out.println("empid= "+empid);
//		System.out.println("name= "+name);
//		System.out.println("companyname= "+companyname);
//	}
//	//static method
//	static void details(int empid1, String name1)
//	{
//	     String st;
//		//System.out.println("empid= "+empid);
//		//System.out.println("name= "+name);
//		System.out.println("companyname= "+companyname);
//	}
//	//static block
//	static
//	{
//		System.out.println("block");
//	}
//	
//	{
//		System.out.println("block");
//	}
// 
//	public static void main(String[] args) {
//		Oops1 emp=new Oops1();
//		emp.show(101, "Rohit");
//		emp.show(102, "Soham");
//		emp.show(103, "Mohan");
//		//show(103, "Mohan");
//		details(101, "Rohit");
// 
//	}
// 
//}
//


class Oops1{
	
	int x=10;
	String name, type;
	
	void eat(int x1, String name, String type) {
		
		this.x=x1;
		this.name=name;
		this.type=type;
		
		System.out.println(x);
		System.out.println(name);
		System.out.println(type);
		  
	
	}


	public static void main(String[] args) {
	
		Oops1 obj=new Oops1();
		obj.eat(100, "dog"," white");
	
	}
}
 