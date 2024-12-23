package lab.daily;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */

interface NestedInteger {

	public boolean isInteger();

	public Integer getInteger();

	public List<NestedInteger> getList();
}

//[[1,2,3], 4, [[1,2], 2 [1,2]]]

public class NestedIterator implements Iterator<Integer> {

	Iterator<Integer> ite;

	ArrayList<Integer> integerList = new ArrayList<>();

	public NestedIterator(List<NestedInteger> nestedList) {
		init(nestedList.iterator());
		ite = integerList.iterator();
	}

	public void init(Iterator<NestedInteger> iterator) {
		while (iterator.hasNext()) {
			NestedInteger n = iterator.next();
			if (n.isInteger()) {
				integerList.add(n.getInteger());
			} else {
				init(n.getList().iterator());
			}
		}
	}

	@Override
	public Integer next() {
		return ite.next();

	}

	@Override
	public boolean hasNext() {
		return ite.hasNext();
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */