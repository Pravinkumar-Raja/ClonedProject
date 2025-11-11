package com.example;


import java.io.*;

public class Demo {
	public static void main(String[] args) {
		DataInputStream ds=new DataInputStream(System.in);
		System.out.println("Enter your name");
String name="";
		try {
			name=ds.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name1="";
		System.out.println("Enter the 2nd name");
		try {
			name1=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name1);
		
	}

}
