import java.util.*;
public class MapEx {
	public static void main(String args[]) {
		Map<String,Integer> c = new HashMap<>();
		
		System.out.println("Enter no of student to enter:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter name of student : ");
			String name = sc.next();
			System.out.println("Enter rollno of student :");
			int no = sc.nextInt();
			c.put(name, no);
		}
		for(Map.Entry<String, Integer> m : c.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
		System.out.println("Enter a student name to find rollno");
		String a = sc.next();
		if(c.containsKey(a)) {
			System.out.println("Roll no is "+c.get(a));
		}
		else
			System.out.println("Name doesn't exist");
		
	}
}
