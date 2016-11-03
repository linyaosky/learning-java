package me.learning.springioc;

import me.learning.springioc.SayApi;

public class SayApiImpl implements SayApi{
	
	public void sayHello() {
		System.out.println("hello");
	}

}
