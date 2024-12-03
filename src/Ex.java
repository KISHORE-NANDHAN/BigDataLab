import java.util.*;

public class Ex {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Set<Integer> t = new TreeSet<Integer>();
		t.add(99);
		t.add(67);
		t.add(567);
		System.out.println(t);
		boolean ele = t.contains(5671);
		System.out.println(ele);
		
		ArrayList<Integer> list = new ArrayList<Integer>(t);
		System.out.println(list);
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(10);
		s.push(20);
		System.out.println(s);
		System.out.println(s.peek());
		s.addAll(t);
		System.out.println(s);
		System.out.println(s.isEmpty());
	}
}
