package me.learning.springioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * springIoC的学习代码
 * 
 * @author linyao
 *
 */
public class HelloTest {
	
	/**
	 * 此处最核心的问题就是：当把配置文件给了ApplicationContext之后，IOC容器是如果管理配置的Bean的（BeanFactory提供了IOC容器的基本功能）。
	 * IOC容器管理Bean的过程：
	 * 1.读取并解析配置文件。
	 * 2.根据元数据创建，组装Bean
	 * 3.提供获取Bean的方法
	 * 
	 */
	@Test
	public void testHello(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring-config.xml");
		SayApi say = ac.getBean("hello",SayApi.class);
		say.sayHello();
	}
}	
