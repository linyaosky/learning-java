package me.learning.collection;

import java.util.Arrays;

/**
 *使用泛型实现动态数组
 */
public class DynamicArray<E> {
	private static final int DEFAULT_CAPACITY = 10; //默认容量
	
	private int size; //需要的大小
	private Object[] elementData; //内部数组
	
	public DynamicArray() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	}
	
	// 动态调整数组大小
	public void ensureCapacity(int minCapacity){
		int oldCapacity = elementData.length;
		if(oldCapacity >= minCapacity){
			return;
		}
		int newCapacity = oldCapacity * 2;
		if(newCapacity < minCapacity){
			newCapacity = minCapacity;
		}
		elementData = Arrays.copyOf(elementData, newCapacity);
	}
	
	public void add(E e){
		ensureCapacity(size+1);
		elementData[size++] = e;
	}
	
	public E get(int index){
		return (E)elementData[index];
	}
	
	public int size(){
		return this.size;
	}
	
	public E set(int index,E element){
		E oldValue = get(index);
		elementData[index] = element;
		return oldValue;
	}
}
