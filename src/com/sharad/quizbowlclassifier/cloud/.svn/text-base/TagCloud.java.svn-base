package com.sharad.quizbowlclassifier.cloud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TagCloud<T extends Tag<?>> implements Set<T> {
	Collection<T> collection;

	public TagCloud() {
		this(new ArrayList<T>());
	}

	public TagCloud(Collection<T> c) {
		collection = c;
	}

	public Collection<T> getCollection() {
		return collection;
	}

	public void setCollection(Collection<T> collection) {
		this.collection = collection;
	}

	public String toString() {
		String s = "(";
		for (int i = 0; i < size(); i++) {
			s += "[";
			s += toArray(new Tag[collection.size()])[i];

			s += "]";
			if (!(i == size() - 1)) {
				s += ",";
			}
		}
		s += ")";
		return s;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean add(T e) {
		Tag[] t = collection.toArray(new Tag[collection.size()]);
		for (int i = 0; i < collection.size(); i++)
			if (e.equals(t[i])) {
				t[i].setFrequency(t[i].getFrequency() + e.getFrequency());
				collection = (Collection<T>) new ArrayList<T>(
						(Collection<? extends T>) Arrays.asList(t));
				return true;
			}
		if (collection.add(e)) {
			return true;
		} else
			return false;

	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		if (collection.addAll(c))
			return true;
		else
			return false;
	}

	@Override
	public void clear() {
		collection.clear();
	}

	@Override
	public boolean contains(Object o) {
		return collection.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return collection.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return collection.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return collection.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return collection.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return collection.retainAll(c);
	}

	@Override
	public int size() {
		return collection.size();
	}

	@Override
	public Object[] toArray() {
		return collection.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		return collection.toArray(a);
	}

	@SuppressWarnings("unchecked")
	public TagCloud<T> trim(int n) {
		List<T> temp = new ArrayList<T>();
		for (int i = 0; i < toArray(new Tag[collection.size()]).length; i++) {
			if (toArray(new Tag[collection.size()])[i].getFrequency() >= n) {
				temp.add((T) toArray(new Tag[collection.size()])[i]);
			}
		}
		return new TagCloud<T>(temp);
	}

}
