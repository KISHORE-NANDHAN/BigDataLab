import java.util.*;

class HashSetExample1 {
    public static void main(String args[]) {
        // Creating HashSet and adding elements
        HashSet<String> set = new HashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");

        // Iterating through the HashSet
        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        
        Set<Integer> t = new TreeSet<Integer>();
        t.add(99);
        t.add(67);
        t.add(98);
        System.out.println(t);
        t.remove(98);
        System.out.println(t);
    }
}
