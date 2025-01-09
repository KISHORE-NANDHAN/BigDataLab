import java.util.*;

public class Main1 {
	public static void main(String args[]) {
		Map<String,Double> m = new HashMap<String,Double>();
		m.put("ABC", 109.9);
		m.put("CDE", 349.1);
		m.put("HIJ", 456.4);
		
		m.putIfAbsent("ABC", 234567.9);
		System.out.println(m);
		
		//Traverse Map
		for(Map.Entry<String,Double> me : m.entrySet()) {
			System.out.println(me.getKey());
			System.out.println(me.getValue());
		}
		
		Iterator<?> i1 = m.entrySet().iterator();
		while(i1.hasNext()) {
			System.out.println(i1.next());
		}
	}
}
