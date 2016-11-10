package me.learning.springaop;
/**
 * 定义目标类
 * @author Administrator
 *
 */
public class HelloWorldServiceImpl implements HelloWordService{

	public void sayHello() {
		System.out.println("Hello");
	}

}
