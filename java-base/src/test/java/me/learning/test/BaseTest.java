package me.learning.test;

import org.junit.Test;

public class BaseTest {
	
	@Test
	public void test1(){
		int a = 0;
		int b = 5;
		a=b++;
		System.out.println(a+","+b);
		a=++b;
		System.out.println(a+","+b);
	}
	
	@Test
	public void test2(){
		String a = "hello";
		String b = "he" + new String("llo");
		String c = "he" + "llo";
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(b);
		
		StringBuilder f = new StringBuilder();
	}
}
