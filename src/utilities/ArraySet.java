/**
* A class that implements an arraySet using an underlying arrayList
*
*
* @author <Moultrie Dangerfield, Flynn Nisbet, Mengsrun Nit>
* @date <08/30/23>
*/



package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Spliterator;

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;

	public ArraySet()
	{
		_list = new ArrayList<E>();
	}

	@Override
	public boolean add(E e) {
		//checking for duplicates before adding
		if(!_list.contains(e)) {
			_list.add(e);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		//boolean to see if a value was added
		boolean added = false;
		for(E value: c) {
			if(!_list.contains(value)) {
				_list.add(value);
				added = true;
			}
		} 
		return added;
	}

	@Override
	public int size() {
		return _list.size();
	}

	@Override
	public boolean isEmpty() {
		return _list.isEmpty();
	}

	@Override
	public Object[] toArray() {
		return _list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return _list.toArray(a);
		
	}

	@Override
	public boolean remove(Object o) {
		return _list.remove(o);
	}

	@Override
	//Checks if a collection contains all the elements of your set
	public boolean containsAll(Collection<?> c) {
		return _list.containsAll(c);
	}

	
	@Override 
	public boolean removeAll(Collection<?> c) {
		return _list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return _list.retainAll(c);
	}

	@Override
	public void clear() {
		_list.clear();
	}

	@Override
	public E get(int index) {
		return _list.get(index);
	}

	@Override
	public E set(int index, E element) {
		return _list.set(index, element);
	}

	@Override 
	public void add(int index, E element) {
		//checks for bounds before adding 
		if(index >= 0 && index < _list.size()) {
		_list.add(index, element);
		}
	}

	@Override
	public int indexOf(Object o) {
		return _list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return _list.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return _list.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return _list.listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return _list.subList(fromIndex, toIndex);
	}

	@Override
	public boolean contains(Object o) {
		return _list.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return _list.iterator();
	}

	@Override
	public Spliterator<E> spliterator() {
		return List.super.spliterator();
	}


	@Override
	public E remove(int index) {
		return _list.remove(index);
	}

}