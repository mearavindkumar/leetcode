package lab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsLearn {

	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<>();
		strList.add("1");
		strList.add("2");
		strList.add("3");

		ArrayList<String> strList1 = new ArrayList<>();
		strList1.add("A");

		strList1.add("B");
		strList1.remove("B");

//		System.out.println(strList.equals(strList1));

		ArrayList<String> copyList = new ArrayList<String>(strList);

		ArrayList<String> copyListCloned = (ArrayList<String>) strList.clone();

//		System.out.println(strList == copyList);
//		System.out.println(strList == copyListCloned);
//		System.out.println(strList.equals(copyList));
//		System.out.println(strList.equals(copyListCloned));
//		System.out.println(strList.equals(strList1));

		int capacity = 10;

		int i = 1;
		i++;
//		System.out.println(i);

//		Iterator<String> ite = strList.iterator();
//		ite.forEachRemaining((a) -> {
//			System.out.println(a);
//		});

//		strList.subList(1, 2).forEach((a) -> {
//
//			System.out.println(a);
//		});

		List<String> sub = strList.subList(1, 2);
		sub.add("New");
		sub.add(0, "a");
//		sub.add

		Iterator<String> ite = strList.iterator();
		ite.forEachRemaining((a) -> {
			System.out.println(a);
		});

		strList.stream();

	}

}
