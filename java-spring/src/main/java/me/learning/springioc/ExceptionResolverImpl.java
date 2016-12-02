package me.learning.springioc;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 异常处理实现类
 * 在此使用ioc实现一个可配置的异常处理实现类
 * 主要功能：
 * 1.异常处理的请求是支持通过通配符配置的
 * 2.对于不同的请求可以可以配置不同的异常进行处理方式
 * 3.应用场景：如果一个提供服务的后台。对于web应用如果异常需要返回错误页面。
 * 			而对于APP接口等，如果异常需要返回json数据。如此就可使用该异常解析器进行区分并返回不同的视图
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
	
	public String handleException(String handler,String exceptionType){
		String resolver = this.defaultResolver;
		for(String mapper : this.handlerMappering){
			if(mapper != null && mapper.equalsIgnoreCase(handler)){
				resolver = praseExceptionMap(exceptionType, defaultResolver);
				break;
			}
		}
		System.out.println(resolver);
		return resolver;
	}
	
	public String praseExceptionMap(String exceptionType, String defaultResolver){
		if(!this.exceptionMap.containsKey(exceptionType)){
			return defaultResolver;
		}
		
		return this.exceptionMap.get(exceptionType);
	}
	
	
}
