package mythread;

public class Mythread extends Thread{
	
	
	
	
	
	
	
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	// TODO Auto-gene

	public static void main(String[] args) {
		Mythread t1=new Mythread();
		t1.start();
		Mythread t2=new Mythread();
		t2.start();
		

	}

}
