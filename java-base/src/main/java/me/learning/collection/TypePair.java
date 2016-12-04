package me.learning.collection;
/**
 * 泛型示例
 * 泛型就是类型参数化，处理的数据类型不是固定的，而是可以作为参数传入。
 * 泛型是在编译器中将泛型直接转为了对应的类型。在虚拟机中执行时是没有泛型的。
 *
 * 主要有两个好处：
 * 更好的安全性(如果在内部直接使用Object类型接受，如果外部传入错误的类型。IDE是无法在代码编写时发现问题的)
 * 更好的可读性(可以省去繁琐的类型转换)
 * 
 * 典型应用：Java容器
 * 
 * 泛型包括：
 * 1.泛型类
 * 2.泛型方法
 * 3.泛型接口
 * 4.泛型参数(类型参数的限定:通过extends)
 * 
 * 泛型是计算机程序中一种重要的思维方式，它将数据结构和算法与数据类型相分离。
 * 使得同一套数据结构和算法，能够应用于各种数据类型，而且还可以保证类型安全，提高可读性。
 * 
 * 泛型中的通配符 ？
 * 在之前的泛型使用中泛型参数的类型有：<T> <T,V> <T entends Number> 
 * 通配符式的： <?> <? extends E> <? super E>
 * 
 * 细节和局限性:
 * 
 * 
 */
public class TypePair<T,V> implements Comparable<TypePair<T, V>>{
	
	T first;
	V second;
	
	public TypePair(T first, V second) {
		this.first = first;
		this.second = second;
	}
	
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public V getSecond() {
		return second;
	}
	public void setSecond(V second) {
		this.second = second;
	}
	
	//泛型方法
	public static <T,V> TypePair<T, V> getInstance(T first,V second){
		return new TypePair<>(first, second);
	}
	
	public static void main(String[] args) {
		TypePair<Integer,String> pair = TypePair.getInstance(10,"yyy");
		System.out.println(pair.getFirst()+","+pair.getSecond());
	}

	@Override
	public int compareTo(TypePair<T, V> typePair) {
		if(this.getFirst()!=null && typePair.getFirst()!=null){
			return this.getFirst().hashCode()-typePair.getFirst().hashCode();
		}else{
			return 0;
		}
	}
}
