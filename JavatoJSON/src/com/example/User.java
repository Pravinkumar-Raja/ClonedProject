package com.example;

import com.google.gson.Gson;

public class User {
	public static void main(String[] args) {
		EmployeeBean eb=new EmployeeBean();
		eb.setEmpid(101);
		eb.setEmpname("Vishwa");
		eb.setSalary(40000);
		System.out.println(eb);
		Gson json=new Gson();
		
		System.out.println(json.toJson(eb));
		
	}

}
