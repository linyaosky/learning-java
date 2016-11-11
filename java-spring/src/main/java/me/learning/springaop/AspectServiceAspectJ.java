package me.learning.springaop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectServiceAspectJ {
	
	// 定义切入点(将匹配目标方法的第一个参数类型为通知方法实现中参数名为“param”的参数类型)
	@Pointcut(value="execution(* me.learning..*.sayHello(..)) && args(param)", argNames="param") 
	public void Pointcut(String param){}
	
	// 前置通知
	@Before(value = "Pointcut(param)", argNames = "param")  
	public void beforeAdvice(String param) {  
	    System.out.println("===========before advice param:" + param);  
	}  
    
    //后置通知  
	@After(value = "Pointcut(param)", argNames = "param")  
    public void afterFinallyAdvice(String param) {  
        System.out.println("===========after advice param:" + param);  
    }  
}
