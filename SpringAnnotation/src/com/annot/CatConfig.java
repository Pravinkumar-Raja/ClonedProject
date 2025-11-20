package com.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class CatConfig {
	
	@Bean(name="cat")
	@Scope(value="singleton")
	public Cat meth1()
	{
		return new Cat();
	}

}
