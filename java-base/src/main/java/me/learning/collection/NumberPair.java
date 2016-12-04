package me.learning.collection;

/**
 * 实现泛型参数类型的限定
 *
 */
public class NumberPair<T extends Number,V extends Number> extends TypePair<T, V>{

	public NumberPair(T first, V second) {
		super(first, second);
	}

	public int compareTo(NumberPair<T, V> numberPair) {
		if(this.getFirst()!=null && numberPair.getFirst()!=null){
			return this.getFirst().intValue()-numberPair.getFirst().intValue();
		}else{
			return 0;
		}
	}
}
