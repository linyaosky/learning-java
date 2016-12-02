package me.learning.springaop;
/**
 * 定义目标类
 * @author Administrator
 *
 */
public class HelloWorldServiceImpl implements HelloWordService{

	public void sayHello(String content) {
		System.out.println(content);
	}

}
