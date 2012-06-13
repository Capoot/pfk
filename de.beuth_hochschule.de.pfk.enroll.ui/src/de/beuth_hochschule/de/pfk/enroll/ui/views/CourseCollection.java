package de.beuth_hochschule.de.pfk.enroll.ui.views;

import java.util.Collection;
import java.util.Iterator;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;

public class CourseCollection implements Collection<Course> {

	private Collection<Course> items;

	public CourseCollection(Collection<Course> items) {
		this.items = items;
	}

	@Override
	public boolean add(Course e) {
		return items.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends Course> c) {
		return items.addAll(c);
	}

	@Override
	public void clear() {
		items.clear();
	}

	@Override
	public boolean contains(Object o) {
		return items.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return items.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public Iterator<Course> iterator() {
		return items.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return items.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return items.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return items.retainAll(c);
	}

	@Override
	public int size() {
		return items.size();
	}

	@Override
	public Object[] toArray() {
		return items.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return items.toArray(a);
	}
}
