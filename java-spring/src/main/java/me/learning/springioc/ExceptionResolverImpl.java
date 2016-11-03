package me.learning.springioc;

import java.util.List;
import java.util.Map;

/**
 * 异常处理实现类
 * 在此使用ioc实现一个可配置的异常处理实现类
 * 主要功能：
 * 1.异常处理的请求是支持通过通配符配置的
 * 2.对于不同的异常可以配置不同的处理方式
 * @author Administrator
 *
 */
public class ExceptionResolverImpl implements ExceptionResolver {
	
	// 配置的请求列表
	private List<String> handlerMappering = null;
	
	// 配置的异常处理map
	private Map<String,String> exceptionMap = null;
	
	// 默认处理方式
	private String defaultResolver = null;

	// 提供默认set方法
	public void setHandlerMappering(List<String> handlerMappering) {
		this.handlerMappering = handlerMappering;
	}

	public void setExceptionMap(Map<String, String> exceptionMap) {
		this.exceptionMap = exceptionMap;
	}

	public void setDefaultResolver(String defaultResolver) {
		this.defaultResolver = defaultResolver;
	}
	
	
}
