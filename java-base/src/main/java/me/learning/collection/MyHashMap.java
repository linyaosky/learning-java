package me.learning.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 集合框架
 * [Iterator]
 * 		[Collection](AbstractCollection)
 * 			Set(AbstractSet)
 * 					HashSet
 * 					TreeSet
 * 			[List](AbstractList,AbstractSequentialList)
 * 					ArrayList
 * 					LinkedList
 * 			[Map](AbstractMap)[SortedMap,NavigableMap]
 *  				HashMap	
 *  					 LinkedHashMap
 *  					 ConcurrentHashMap 
 *   				TreeMap	
 *      			WeakHashMap	
 *    				HashTable
 * Collections
 * Arrays
 */
public class MyHashMap {
	/**
	 * 工作原理：通过hash的方法，通过put和get存储和获取对象。
	 * 存储对象时，我们将K/V传给put方法时，它调用hashCode计算hash从而得到bucket位置，
	 * 进一步存储，HashMap会根据当前bucket的占用情况自动调整容量(超过Load Factor则resize为原来的2倍)。
	 * 获取对象时，我们将K传给get，它调用hashCode计算hash从而得到bucket位置，并进一步调用equals()方法确定键值对。
	 * 如果发生碰撞的时候，Hashmap通过链表将产生碰撞冲突的元素组织起来.
	 * 在Java 8中，如果一个bucket中碰撞冲突的元素超过某个限制(默认是8)，则使用红黑树来替换链表，从而提高速度。 
	 * 
	 * 参数：（当entries的数量大于负载后，将容量扩充为当前2倍）
	 * 容量(Capacity)。默认16
	 * 负载因子(Load factor).默认0.75
	 * 
	 * 关键字：允许null键/值、非同步、不保证有序(比如插入的顺序)、也不保证序不随时间变化。
	 */
	
	//修改容量为：20
	HashMap<String, String> map1 = new HashMap<String, String>(20);
	
	//修改容量为20，负载为0.85
	HashMap<String, String> map2 = new HashMap<String, String>(20 ,0.85f);
	
	//map的遍历
	@Test
	public void operateMap(){
		map1.put("1", "11");
		map1.put("2", "22");
		map1.put(null, "n"); //特殊处理，hashcode为0
		map1.put("3", "33");
		
		for(Map.Entry<String,String> entry : map1.entrySet()){
			System.out.println(entry.getKey() +": "+entry.getValue());
		}
	}
	
	/**
	 * HashTable
	 * 关键字：不允许null键/值、同步（是线程安全的，多个线程可以共享）、不保证有序(比如插入的顺序)、也不保证序不随时间变化。
	 */
	
}
