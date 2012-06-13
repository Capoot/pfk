package de.beuth_hochschule.de.pfk.enroll.ui.views;

import java.util.Collection;
import java.util.Iterator;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;

public class StudentCollection implements Collection<Student> {

	private Collection<Student> items;

	public StudentCollection(Collection<Student> items) {
		this.items = items;
	}
	
	@Override
	public boolean add(Student e) {
		return items.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends Student> arg0) {
		return items.addAll(arg0);
	}

	@Override
	public void clear() {
		items.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		return items.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return items.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public Iterator<Student> iterator() {
		return items.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return items.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return items.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return items.retainAll(arg0);
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
	public <T> T[] toArray(T[] arg0) {
		return items.toArray(arg0);
	}
}
