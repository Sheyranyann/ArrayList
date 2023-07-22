import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        System.out.println();

        //1
        ArrayList<String> arr1 = new ArrayList<>();
        System.out.println("Size of arr1: " + arr1.size());
        System.out.println("Capacity of arr1: " + arr1.capacity());
        System.out.println("Is arr1 empty? " + arr1.isEmpty());
        List<String> strList = new ArrayList<>("A", "B");
        //removing from empty Arraylist
        System.out.println("Removing list's elements: " + arr1.removeAll(strList));
        strList = new ArrayList<>();
        //removing with empty List
        System.out.println("Removing list's elements: " + arr1.removeAll(strList));
        String str = "Hello";
        System.out.println("Does arr1 contain " + str + ": " + arr1.contains("Hello") + "  index = " + arr1.indexOf(str));
        //negaitve
        System.out.println(arr1.set(-4, "A"));
        //out of bounds
        System.out.println(arr1.set(0, "A"));
        arr1.add("C");
        arr1.add(0, "B");
        arr1.add(0, "A");
        arr1.add(3,"D");
        System.out.println("Size of arr1: " + arr1.size());
        System.out.println("ARR1 = " + arr1);
        List<String> list1 = new ArrayList<>("G", "H", "I");
        arr1.addAll(4, list1);
        System.out.println("ARR1 = " + arr1);
        System.out.println("Size of arr1: " + arr1.size());
        list1 = new ArrayList<>("E", "F");
        System.out.println("Size of arr1: " + arr1.size());
        System.out.println("Capacity of arr1: " + arr1.capacity());
        System.out.println("ARR1 = " + arr1);
        strList = new ArrayList<>("A", "B");
        System.out.println("Does arr1 contain A and B: " + arr1.containsAll(strList));
        strList = new ArrayList<>("A", "B", "Z");
        System.out.println("Does arr1 contain A, B and Z: " + arr1.containsAll(strList));
        System.out.println("Removing list's elements: " + arr1.removeAll(strList));
        System.out.println("ARR1 = " + arr1);

        System.out.println();

        //2
        ArrayList<Integer> arr2 = new ArrayList<>(2, 4, 6, 9, 4, 8, 9, 6, 8, 6);
        System.out.println("HASHCODE:  " + arr2.hashCode());
        System.out.println("arr2: " + arr2);
        //negative index
        List<Integer> list2 = arr2.subList(-1, 3);
        //not valid index
        list2 = arr2.subList(3, 1);
        //valid index
        list2 = arr2.subList(1, 3);
        System.out.println("Sublist: " + list2);
        System.out.println("Size of arr2: " + arr2.size());
        System.out.println("Capacity of arr2: " + arr2.capacity());
        System.out.println("Is arr2 empty? " + arr2.isEmpty());
        System.out.println("Element 45 is added: " + arr2.add(45));
        int index = 10;
        Integer x = arr2.get(index);
        System.out.println("Element in " + index + "'th index is " + x);
        index = 11;
        System.out.println("Element in " + index + "'th index is " + arr2.get(index));
        System.out.println("Size of arr2: " + arr2.size());
        System.out.println("Capacity of arr2: " + arr2.capacity());
        Integer num = 9;
        System.out.println("Does arr2 contain " + num + ": " + arr2.contains(num) + " first index = " + arr2.indexOf(num) + "  last index = " + arr2.lastIndexOf(num));
        System.out.println("Does arr2 contain " + 150 + ": " + arr2.contains(150) + " first index = " + arr2.indexOf(150) + "  last index = " + arr2.lastIndexOf(150));
        index = arr2.indexOf(num);
        System.out.println("Replacing " + arr2.set(index, 150) + " with " + 150);
        System.out.println("arr2[" + index + "] = " + arr2.get(index));
        System.out.println("ARRAYLIST TO ARRAY");
        System.out.println(arr2);
        Object[] array = arr2.toArray();
        System.out.println(java.util.Arrays.toString(array));


        System.out.println();

        //3
        A ob1 = new A();
        A ob2 = new A();
        A ob3 = new A();
        ArrayList<A> arr3 = new ArrayList<>(ob1, ob2);
        System.out.println("Size of arr3: " + arr3.size());
        A ob = arr3.get(0);
        System.out.println("Does arr3 contain ob3: " + arr3.contains(ob3) + "  index = " + arr3.indexOf(ob3));
        System.out.println("Does arr3 contain ob2: " + arr3.contains(ob2) + "  index = " + arr3.indexOf(ob2));
        System.out.println("Size = " + arr3.size());
        System.out.println("Capacity = " + arr3.capacity());
        System.out.println("Clearing arr3: ");
        arr3.clear();
        //printing empty array
        System.out.println("ARR3 = " + arr3);
        System.out.println("Size = " + arr3.size());
        System.out.println("Capacity = " + arr3.capacity());
        System.out.println(arr3.get(0));

        System.out.println();

        //4
        ArrayList<Double> arr4 = new ArrayList<>(12.5, 5.3, 7.3, 5.2, 21.3, 2.3, 40.1, 16.1, 1.2, 0.3, 51.6);
        System.out.println("Size = " + arr4.size());
        System.out.println("Capacity = " + arr4.capacity());
        System.out.println("Removing 5.3: " + arr4.remove(5.3));
        System.out.println("Removing 553.2: " + arr4.remove(553.2));
        System.out.println(arr4.remove(122));
        System.out.println("Removing " + arr4.remove(5) + " element");
        System.out.println("ARR4 = " + arr4);
        System.out.println();

        //5
        ArrayList<Number> arr5 = new ArrayList<>(2,3,5,6,7);
        String[] a = new String[16];
        Integer[] b = new Integer[16];
        Integer[] c = new Integer[3];
        System.out.println(Arrays.toString(arr5.toArray(a)));
        System.out.println(Arrays.toString(arr5.toArray(b)));
        System.out.println(Arrays.toString(arr5.toArray(c)));
        List<Integer> intArr = new ArrayList<>(2,3,5,6,7);
        System.out.println("Retaining: " + arr5.retainAll(intArr));
        intArr = new ArrayList<>(3,5);
        System.out.println("Retaining: " + arr5.retainAll(intArr));
        System.out.println(arr5);
        intArr = new ArrayList<>();
        System.out.println("Retaining: " + arr5.retainAll(intArr));
        System.out.println(arr5);



    }

}

class A {}