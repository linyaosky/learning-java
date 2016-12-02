package me.learning.springioc;

/**
 * 异常处理接口
 * @author Administrator
 *
 */
public interface ExceptionResolver {
	
	// 异常处理方法
	public String handleException(String handler,String exceptionType);
}
