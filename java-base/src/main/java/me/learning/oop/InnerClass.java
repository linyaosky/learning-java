package me.learning.oop;


import org.junit.Test;

/**
 * 内部类学习
 * 内部类与包含它的外部类有比较密切的关系，而与其他类关系不大，定义在类内部，可以实现对外部完全隐藏，可以有更好的封装性，代码实现上也往往更为简洁。
 * 
 * 内部类分类：
 * 1.静态内部类
 * 	典型使用案例：表示链表的LinkedList类内部有一个私有静态内部类Node，表示链表中的每个节点。
 * 2.成员内部类
 * 3.方法内部类
 * 4.匿名内部类: 简化代码
 *
 * 
 */
public class InnerClass {
	
	private  static int shared = 100;
	
	private int pri = 11;
	
	public void action(){
		System.out.println("action");
	}
	
	//静态内部类
	public static class StaticInner {
		public void innerMethod(){
            System.out.println("inner " + shared);
        }
	}	
	@Test
	public void testStaticInner(){
		StaticInner sta = new StaticInner();
		sta.innerMethod();
	}
	
	//成员内部类
	public class MemberInner{
		public void innerMethod(){
            System.out.println("inner " + pri);
            InnerClass.this.action();
        }
	}
	@Test
	public void MemberInner(){
		MemberInner mem = new MemberInner();
		mem.innerMethod();
	}
	
	
	// 方法内部类
	public void methodInnerTest(final String param){
		final String share = "look";
		class MethodInner{
			public void innerMethod(){
	            System.out.println("inner " + shared);
	            System.out.println("param " + param);
	            System.out.println("share " + share);
	        }
		}
		
		MethodInner methodInner = new MethodInner();
		methodInner.innerMethod();
	}
	@Test
	public void testMethodInner(){
		methodInnerTest("666");
	}
	
	// 匿名内部类（必须有继承父类或实现接口）
	public void anonymousInnerTest(final int x,final int y){
		
		AbstractPoint point = new AbstractPoint(){

			@Override
			public void draw(int x, int y) {
				System.out.println("draw:"+x+","+y);
			}
		};
		point.draw(x, y);
	}
	@Test
	public void testAnonymousInner(){
		anonymousInnerTest(4, 9);
	}
	
}
