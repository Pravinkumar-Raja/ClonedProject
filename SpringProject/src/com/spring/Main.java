package com.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ct=new ClassPathXmlApplicationContext("PA.xml","PA2.xml");//initialize container
		
		PK pk=(PK) ct.getBean("pa");
		System.out.println(pk.getMsg());
		
		PK pk1=(PK)ct.getBean("pa1");
		System.out.println(pk1.getMsg());
		
		PK pk2=(PK)ct.getBean("pa2");
		System.out.println(pk2.getMsg());
		
		PK pk3=(PK)ct.getBean("pa3");
		pk3.setMsg("It is going to be tough. So.....");
		System.out.println(pk3.getMsg());
		
		
		BeanFactory ctx1= new XmlBeanFactory(new ClassPathResource("PA2.xml"));
		PK pk4=(PK)ctx1.getBean("pa3");
		pk4.setMsg("Prepare Well");
		System.out.println(pk4.getMsg());
		
		
		
		
	}

}
