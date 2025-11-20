package com.annot;

import org.springframework.context.annotation.Bean;

public class HelloConfig {
	
	@Bean(name="h1")
	public Hello meth1() {
		return new Hello();
	}

}
