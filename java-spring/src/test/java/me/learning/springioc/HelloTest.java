package me.learning.springioc;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.learning.springaop.HelloWordService;

/**
 * spring的学习代码
 * 
 * @author Administrator
 *
 */
public class HelloTest {
	
	/**
	 * 此处最核心的问题就是：当把配置文件给了ApplicationContext之后，IOC容器是如果管理配置的Bean的（BeanFactory提供了IOC容器的基本功能）。
	 * IOC容器管理Bean的过程：（Bean的定义、Bean的创建以及对 Bean的解析）
	 * 1.读取并解析配置文件。
	 * 2.根据元数据创建，组装Bean
	 * 3.提供获取Bean的方法
	 * 
	 * 此处的getBean方法，是ApplicationContext实现了ListableBeanFactory和HierarchicalBeanFactory接口，这两个接口都继承自BeanFactory
	 * 而getBean方法是在DefaultListableBeanFactory类中实现。
	 * 
	 * getBean方法背后发生的处理：
	 * 1.解析配置文件。通过bean的解析方法，BeanDefinitionReader接口去解析配置文件。将配置文件中的定义转为BeanDefinition对象
	 * 	（当然此处解析bean的方式不限于配置文件，还有注解方式等，应该通过不同的实现类来实现而已）
	 * 2.初步查看所有的解析完成的bean都属存在一个beanDefinitionMap中，Map类型：ConcurrentHashMap<String, BeanDefinition>(64)
	 * 3.根据传入的名称和类型在map中匹配后返回
	 * 
	 * springIOC实现原理：
	 * 1.加载配置文件的实现类：ClassPathXmlApplicationContext的构造方法中：设置了configLocations，调用了refresh()方法。
	 * 2.此refresh()方法就是构建Bean关系网的入口：AbstractApplicationContext 类的 refresh()。
	 * 3.refresh()方法的内容：
	 * 		构建 BeanFactory：刷新BeanFactory，创建原始对象： DefaultListableBeanFactory。开始加载、解析 Bean 的定义：loadBeanDefinitions()。也就是把用户定义的数据结构转化为 Ioc 容器中的特定数据结构
	 * 		注册可能感兴趣的事件：使用者可以在此扩展bean的功能。（此过程使用的是ConfigurableListableBeanFactory：防止一些数据被用户随意修改）
	 * 		创建 Bean的实例对象：从beanDefinitionMap获取定义。先实例化FactoryBean对象，然后建立示例对象之间的关系。
	 * 		触发被监听的事件：初始化监听事件和对系统的其他监听者的注册，监听者必须是 ApplicationListener 的子类
	 * 
	 * 启示： refresh()方法中：invokeBeanFactoryPostProcessors() 的实现是：获取实现 BeanFactoryPostProcessor 接口的子类。并执行它的 postProcessBeanFactory() 方法
	 * 这就是平时在使用一些功能时（比如添加过滤器等）：只要实现接口并实现方法，过滤器就会自动调用实现的方法。就是通过类似的原理。使用反射实现。
	 * 
	 * spring在此提供的扩展点：
	 * 		可以扩展BeanFactory：对创建bean的过程增加控制
	 * 		可以扩展FactoryBean：对创建完成的bean解析修改
	 */
	@Test
	public void testHello(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring-config.xml");
		SayApi say = ac.getBean("hello",SayApi.class);
		say.sayHello();
	}
	
	@Test
	public void testExceptionResolver(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring-config.xml");
		ExceptionResolver resolver = ac.getBean("ExceptionResolver",ExceptionResolver.class);
		
		resolver.handleException("1001", "NullPointException");
		resolver.handleException("login", "MyException");
		resolver.handleException("1001", "Exception");
		resolver.handleException("1000", "NullPointException");
		resolver.handleException("1000", "Exception");
	}
	
	@Test
	public void  testAop(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringAop-config.xml");
		HelloWordService say = ac.getBean("HelloWorldServiceImpl",HelloWordService.class);
		say.sayHello("hi");
	}
}	
