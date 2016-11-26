package me.learning.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
/**
 * 继承了HashMap
 *
 * 扩展HashMap增加双向链表的实现，号称是最占内存的数据结构。
 * 支持iterator()时按Entry的插入顺序来排序(但是更新不算， 如果设置accessOrder属性为true，则所有读写访问都算)。 
 * 实现上是在Entry上再增加属性before/after指针，插入时把自己加到Header Entry的前面去。
 * 如果所有读写访问都要排序，还要把前后Entry的before/after拼接起来以在链表中删除掉自己。
 */
public class MyLinkedHashMap {

	//修改容量为：20
	Map<String, String> map1 = new LinkedHashMap<String, String>(20);
		
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
			System.out.println(map1);
		}
}
