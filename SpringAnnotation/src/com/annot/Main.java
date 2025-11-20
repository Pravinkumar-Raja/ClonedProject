package com.annot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(HelloConfig.class);
		Hello h1=ctx.getBean(Hello.class);
		h1.setMsg("Welcome");
		System.out.println(h1.getMsg());
		
		Hello h2=(Hello)ctx.getBean("h1");
		h2.setMsg("to UST");
		System.out.println(h2.getMsg());
		
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("Beans.xml");
		Cat c1=(Cat)ctx1.getBean("c1");
		System.out.println(c1.getLegs());
		System.out.println(c1);
		
		Cat c2=(Cat)ctx1.getBean("c2");
		System.out.println(c2.getName());
		System.out.println(c2);
		
		Cat c3=(Cat)ctx1.getBean("c3");
		System.out.println(c3.getName()+" "+c3.getLegs());
		System.out.println(c3);
		
		Cat c=(Cat)ctx1.getBean("c");
		System.out.println(c);
		
		ApplicationContext ctx2=new AnnotationConfigApplicationContext(CatConfig.class);
		Cat c4=(Cat)ctx2.getBean("cat");
		System.out.println(c4.getLegs());
		
		AbstractApplicationContext ctx3=new ClassPathXmlApplicationContext("Beans.xml");
		Cat c5=(Cat)ctx3.getBean("c5");
		System.out.println(c5.getName());
		ctx3.registerShutdownHook();
	
	}
}
