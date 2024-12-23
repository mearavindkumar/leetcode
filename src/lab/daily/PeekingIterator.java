package lab.daily;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> ite;
	Integer current;

	public PeekingIterator(Iterator<Integer> iterator) {
		ite = iterator;
		current = ite.hasNext() ? ite.next() : null;

	}

	public Integer peek() {
		return current;
	}

	@Override
	public Integer next() {
		Integer next = current;
		current = ite.hasNext() ? ite.next() : null;
		return next;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}
}