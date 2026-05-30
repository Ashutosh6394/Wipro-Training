package Queue1;

import java.util.*;

public class First1 {

	public static void main(String[] args) {
		
		Queue<String> q=new PriorityQueue<String>(); 
		
		q.add("Meerut");
		q.add("Delhi");
		q.add("Chennai");
		q.add("Noida");
		q.add("Ayodhya");
		q.add("Hyderabad");
		System.out.println(q);
		q.remove();
		System.out.println(q);
		q.remove();
		System.out.println(q);
		q.remove();
		System.out.println(q.offer("Alpha"));
		System.out.println(q.peek());
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q);
		
		// TODO Auto-generated method stub

	}

}
